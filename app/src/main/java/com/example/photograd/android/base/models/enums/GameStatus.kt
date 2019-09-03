package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class GameStatus(val value: Int)
{
    @SerializedName("0.0")
    CHALLENGED(0),
    @SerializedName("1.0")
    ACTIVE(1),
    @SerializedName("2.0")
    FINISHED(2),
    @SerializedName("3.0")
    INTERRUPTED(3),
    @SerializedName("4.0")
    DECLINED(4)
}