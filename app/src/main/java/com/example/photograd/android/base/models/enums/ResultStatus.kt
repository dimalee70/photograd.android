package photograd.kz.photograd.models.enums

/**
 * Created by wokrey@gmail.com on 7/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
enum class ResultStatus(
    val value: String
) {
    /**when result is success*/
    SUCCESS("success"),

    /**when result is fail due to defined error on the server*/
    FAIL("fail"),

    /**when result is fail due to undefined error on the server*/
    ERROR("error")
}