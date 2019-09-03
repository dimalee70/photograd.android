package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class PurchaseStatus(val value: Int)
{
    @SerializedName("0.0")
    NOT_ACTIVATED(0),
    @SerializedName("1.0")
    ACTIVATED(1),
    @SerializedName("2.0")
    EXPIRED(2)
}