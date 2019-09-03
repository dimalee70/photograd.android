package photograd.kz.photograd.api

import com.example.photograd.android.auth.models.AuthParams
import com.example.photograd.android.base.models.events.ErrorEvent
import com.example.photograd.android.utils.Constants
import com.example.photograd.android.utils.DataHolder
import com.google.gson.Gson
import com.onesignal.OneSignal
import okhttp3.Response
import org.greenrobot.eventbus.EventBus
import photograd.kz.photograd.api.event.SocketEventsHandler
import photograd.kz.photograd.api.event.handlers.EventHandler
import photograd.kz.photograd.models.*
import photograd.kz.photograd.models.enums.ResultStatus
import photograd.kz.photograd.presentation.presenter.SocketEventSubscriber
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by wokrey@gmail.com on 7/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
private const val AUTH_REQUEST_ID = "auth"
private const val EVENT_TYPE = "event"
private const val RESPONSE_TYPE = "response"

object SocketEventsManager {
    private const val TAG = "SocketEventsManager"

     val subscribersMap: HashMap<String, SocketEventSubscriber> = HashMap()
    private val socket = WebSocket
    private val parser = Gson()
    var isClosed = true
        set(value) {
            if (value) {
                clearMaps()
            }
            field = value
        }
    var wasLogged = false
        get() = !DataHolder.sessionid.isNullOrBlank()

    var eventHandler: EventHandler? = SocketEventsHandler(parser)
    private val requestsWaitStack: Stack<BaseSocketRequest> = Stack()
    var authRepository: AuthRepository? = null
    var authing = false
    set(value) {
        field = value
        if (!value){
            notifyAuthFinish()
        }
    }

    fun handleMessage(message: String) {
        val socketMessage = parser.fromJson(message, BaseSocketMessage::class.java)

        when (socketMessage.type) {
            RESPONSE_TYPE -> {
                handleResponse(parser.toJson(socketMessage.payload))
            }
            EVENT_TYPE -> {
                handleEvent(parser.toJson(socketMessage.payload))
            }
            else ->
                return
        }
    }

    fun handleError(error: Throwable, response: Response?) {
        EventBus.getDefault().post(ErrorEvent(error))
    }

    fun send(model: BaseSocketRequest, listener: SocketEventSubscriber) {
        subscribersMap[model.request_id] = listener
        if (isClosed) {
            connect()
        }
        if (authing) {
            requestsWaitStack.push(model)
            return
        }
        socket.send(parser.toJson(model))
    }

    fun connect(){
        if (isClosed) {
            socket.connect()
        }
        if (!DataHolder.sessionid.isNullOrBlank()) {
            authUser()
        }
    }

    fun close(code: Int, message: String) = socket.close(code, message)

    fun clearMaps() = subscribersMap.clear()

    fun generateRequestId(model: Any?) = "${System.currentTimeMillis()}${model.hashCode()}"

    private fun authUser() {
        authing = true
        val sessionId = DataHolder.sessionid
        val authModel = BaseSocketRequest(
            method = ApiMethods.USER_AUTH,
            params = AuthParams(
                sessionId!!,
                "OneSignal.getPermissionSubscriptionState().subscriptionStatus.userId",
                Constants.ANDROID_PLATFORM
            ),
            request_id = AUTH_REQUEST_ID
        )
        authRepository = AuthRepository()
        socket.send(parser.toJson(authModel))


        /*disposable = authRepository!!.sendAuthRequest(model = authModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                authing = false
            }
            .subscribe(
                { result ->
                    NotificationManager.addNotifications(result.notifications)
                    OneSignal.clearOneSignalNotifications()
                    DataHolder.user = result.user
                },
                { error ->
                    EventBus.getDefault().post(ErrorEvent(error))
                }
            )*/
    }

    private fun handleEvent(payload: String){
        eventHandler?.handleEvent(event = parser.fromJson(payload, SocketEvent::class.java))
    }

    private fun handleResponse(payload: String){
        val response = parser.fromJson(payload, SocketResponse::class.java)

        val data = response.data
        val requestId = response.request_id
        val subscriber = subscribersMap.remove(requestId)
        val status = ResultStatus.valueOf(response.status.toUpperCase())

        if (requestId == AUTH_REQUEST_ID){
            authing = false
            return
        }

        when(status){
            ResultStatus.SUCCESS ->
                subscriber?.onSuccessResponse(data, requestId)
            ResultStatus.FAIL ->
                subscriber?.onErrorResponse(SocketException(response.data.toString()), requestId)
            ResultStatus.ERROR ->
                subscriber?.onErrorResponse(Throwable(data.toString()), requestId)
        }
    }
    private fun notifyAuthFinish(){
        for(i in 0..requestsWaitStack.size){
            if (requestsWaitStack.isEmpty()){

                break
            }
            val it = requestsWaitStack.pop()

            val listener = subscribersMap.remove(it.request_id)
            listener ?: return
            send(model = it, listener = listener)

        }

    }

}