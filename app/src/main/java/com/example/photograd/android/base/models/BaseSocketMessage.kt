package photograd.kz.photograd.models

import photograd.kz.photograd.models.enums.SocketEventType

/**
 * Created by wokrey@gmail.com on 7/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class BaseSocketMessage(
    val type: String,
    val payload: Any
)

data class SocketResponse(
    val request_id: String,
    val status: String,
    val data: Any
)

data class SocketEvent(
    val type: SocketEventType,
    val classname: String,
    val object_id: Int,
    val data: Any?,
    val field_name: String?,
    val field_value: String?
)