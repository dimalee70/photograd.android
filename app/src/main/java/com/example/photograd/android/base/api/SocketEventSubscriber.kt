package photograd.kz.photograd.presentation.presenter

/**
 * Created by wokrey@gmail.com on 7/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface SocketEventSubscriber {

    fun onSuccessResponse(data: Any, requestId: String)
    fun onErrorResponse(error: Throwable, requestId: String)
}