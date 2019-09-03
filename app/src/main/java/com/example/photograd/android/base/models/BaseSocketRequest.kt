package photograd.kz.photograd.models

/**
 * Created by wokrey@gmail.com on 7/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class BaseSocketRequest(
    val method: String,
    val params: Any? = null,
    val request_id: String
)

