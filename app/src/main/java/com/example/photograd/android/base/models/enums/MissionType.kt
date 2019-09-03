package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class MissionType(val value: Int)
{
    @SerializedName("0.0")
    MOST_VICTORIES(0),
    @SerializedName("1.0")
    LIMITED_GAMES(1),
    @SerializedName("2.0")
    FAST_VICTORIES(2)
}