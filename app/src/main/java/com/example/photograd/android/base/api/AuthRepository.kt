package photograd.kz.photograd.api

import com.example.photograd.android.auth.login.data.model.LoginData
import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.base.models.events.ErrorEvent
import com.google.gson.Gson
import org.greenrobot.eventbus.EventBus


/**
 * Created by wokrey@gmail.com on 7/11/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class AuthRepository : BaseRepository() {

  /*  fun sendAuthRequest(): Single<LoginData> {
        val sessionId = DataHolder.sessionid
        val authModel = BaseSocketRequest(
            method = ApiMethods.USER_AUTH,
            params = AuthParams(sessionId!!, OneSignal.getPermissionSubscriptionState().subscriptionStatus.userId, ANDROID_PLATFORM),
            request_id = SocketEventsManager.generateRequestId(sessionId)
        )

        return makeSocketRequest(
            model = authModel,
            method = ApiMethods.USER_AUTH,
            classOf = LoginData::class.java
        )
    }*/
    override fun onSuccessResponse(data: Any, requestId: String) {
        val parser = Gson()
        val result = parser.fromJson(parser.toJson(data), LoginData::class.java)
//        NotificationManager.addNotifications(result.notifications)
//        OneSignal.clearOneSignalNotifications()
//        DataHolder.user = result.user
        SocketEventsManager.authing = false
    }

    override fun onErrorResponse(error: Throwable, requestId: String) {
        EventBus.getDefault().post(ErrorEvent(error))
        SocketEventsManager.authing = false
    }
}