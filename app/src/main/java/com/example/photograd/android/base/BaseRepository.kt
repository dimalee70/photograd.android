package com.example.photograd.android.base

import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject
import photograd.kz.photograd.api.SocketEventsManager
import photograd.kz.photograd.models.BaseSocketRequest
import photograd.kz.photograd.presentation.presenter.SocketEventSubscriber
import java.util.concurrent.TimeUnit

/**
 * Created by wokrey@gmail.com on 7/9/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
abstract class BaseRepository(
    val socketManager: SocketEventsManager = SocketEventsManager,
    /**map requestId - subjects, need to return answer*/
    val subjects: HashMap<String, SingleSubject<Any>> = HashMap(),
    /**map requestId - Class<T>, need to know how convert result to*/
    val castTypes: HashMap<String, Class<*>> = HashMap(),
    private val parser: Gson = Gson()
) : SocketEventSubscriber {

    fun <T : Any> makeSocketRequest(model: Any?, method: String, classOf: Class<T>): Single<T> {
        val requestModel = BaseSocketRequest(
            method = method,
            params = model,
            request_id = socketManager.generateRequestId(model)
        )
        val subject = SingleSubject.create<T>()
        subjects[requestModel.request_id] = subject as SingleSubject<Any>
        castTypes[requestModel.request_id] = classOf
        socketManager.send(requestModel, this)

        return subject.timeout(30, TimeUnit.SECONDS) as Single<T>
    }

    override fun onSuccessResponse(data: Any, requestId: String) {
        val subject = subjects.remove(requestId)
        val type = castTypes.remove(requestId)
        subject?.onSuccess(parser.fromJson(parser.toJson(data), type))
    }

    override fun onErrorResponse(error: Throwable, requestId: String) {
        val subject = subjects.remove(requestId)
        subject?.onError(error)
    }

}