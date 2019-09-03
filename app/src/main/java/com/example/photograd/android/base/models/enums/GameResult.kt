package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class GameResult(val value: Int)
{
    @SerializedName("0.0")
    RESULT_NOT_STARTED(0),
    @SerializedName("1.0")
    RESULT_NOT_FINISHED(1),
    @SerializedName("2.0")
    RESULT_WON(2),
    @SerializedName("3.0")
    RESULT_DRAW(3),
    @SerializedName("4.0")
    RESULT_LOST(4)
}