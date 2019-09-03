package photograd.kz.photograd.models.enums

import com.google.gson.annotations.SerializedName

enum class NotificationType(val value: Int)
{
    @SerializedName("0.0")
    CHALLENGE ( 0),
    @SerializedName("1.0")
    CHALLENGE_DECLINED ( 1),
    @SerializedName("2.0")
    PLAYER_TO_ANSWER ( 2),
    @SerializedName("3.0")
    GAME_FINISHED ( 3),
    @SerializedName("4.0")
    FRIENDSHIP_REQUEST ( 4),
    @SerializedName("5.0")
    ACHIEVEMENT_RECIEVED ( 5),
    @SerializedName("6.0")
    MISSION_COMPLETED ( 6),
    @SerializedName("7.0")
    PARTNER_MISSION_REWARD ( 7),
    @SerializedName("8.0")
    PARTNER_MISSION_LOOSE ( 8),
    @SerializedName("9.0")
    FRIENDSHIP_REQUEST_ANSWER ( 9),
    @SerializedName("10.0")
    MARKETING_PUSH ( 10),
    @SerializedName("11.0")
    QUESTION_PROCESSED(11),
    @SerializedName("12.0")
    QUESTION_REJECT(12),
    @SerializedName("100.0")
    PURCHASE ( 100),
    @SerializedName("101.0")
    MISSION_SURRENDER ( 101),
    @SerializedName("102.0")
    CHALLENGE_FRIEND ( 102),
    @SerializedName("103.0")
    GAME_SURRENDER ( 103),
    @SerializedName("104.0")
    WELCOME ( 104),
}