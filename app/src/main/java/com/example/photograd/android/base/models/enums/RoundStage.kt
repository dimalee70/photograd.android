package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class RoundStage(val value: Int)
{
    /**Before a category is selected*/
    @SerializedName("0.0")
    NOT_STARTED(0),

    /**Starting from the time when a category is selected
     * to first player submit answers */
    @SerializedName("1.0")
    FIRST_STAGE(1),

    /**Starting from the time when first player submit answers
     * to second player is answered*/
    @SerializedName("2.0")
    SECOND_STAGE(2),

    /**After second player submit answers*/
    @SerializedName("3.0")
    FINISHED(3)
}