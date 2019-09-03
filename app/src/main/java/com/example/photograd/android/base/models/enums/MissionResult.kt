package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class MissionResult(val value: Int)
{
    @SerializedName("1")
    LOOSE(1),
    @SerializedName("2")
    WIN(2)
}