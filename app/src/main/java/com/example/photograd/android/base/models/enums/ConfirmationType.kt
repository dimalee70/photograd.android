package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName


enum class ConfirmationType(val value: String)
{
    @SerializedName("challenge")
    challenge("challenge"),
    @SerializedName("purchase")
    purchase("purchase")
}