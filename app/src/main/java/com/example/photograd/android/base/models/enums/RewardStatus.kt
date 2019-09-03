package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class RewardStatus(val value: Int)
{
    @SerializedName("0.0")
    NOT_RECEIVED(0),
    @SerializedName("1.0")
    NOT_ACTIVATED(1),
    @SerializedName("2.0")
    ACTIVATED(2),
    @SerializedName("3.0")
    EXPIRED(3)
}