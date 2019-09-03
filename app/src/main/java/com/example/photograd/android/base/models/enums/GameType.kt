package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class GameType(val value: Int)
{
    @SerializedName("0.0")
    TYPE_DUEL(0),
    @SerializedName("1.0")
    TYPE_MISSION(1),
    @SerializedName("2.0")
    TYPE_PARTNER_MISSION(2)
}