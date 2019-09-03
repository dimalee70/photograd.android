package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

/**
 * Created by wokrey@gmail.com on 8/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
enum class SocketEventType(
    val value: Int
) {
    @SerializedName("0.0")
    OBJECT_CHANGED(0),

    @SerializedName("1.0")
    OBJECT_CREATED(1),

    @SerializedName("2.0")
    OBJECT_DELETED(2)
}