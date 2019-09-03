package photograd.kz.photograd.api

import java.lang.Exception

/**
 * Created by wokrey@gmail.com on 7/9/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class SocketException(
    override val message: String
): Exception(message) {

}