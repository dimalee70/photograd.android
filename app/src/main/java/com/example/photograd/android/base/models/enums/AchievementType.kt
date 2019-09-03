package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class AchievementType(val value: Int)
{
    @SerializedName("0.0")
    TYPE_VICTORIES(0),
    @SerializedName("1.0")
    TYPE_GAMES(1)
}