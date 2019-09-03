package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class RewardType(val value: Int)
{
    @SerializedName("0.0")
    APPLES(0),
    @SerializedName("1.0")
    PRIZE(1)
}