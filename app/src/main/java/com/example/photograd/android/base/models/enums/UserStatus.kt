package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class UserStatus(val value: Int)
{
    @SerializedName("0.0")
    NOT_CONFIRMED(0),
    @SerializedName("1.0")
    CONFIRMED(1),
    @SerializedName("2.0")
    RATED(2)
}
