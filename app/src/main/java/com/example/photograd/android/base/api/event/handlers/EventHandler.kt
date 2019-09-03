package photograd.kz.photograd.api.event.handlers

import photograd.kz.photograd.models.SocketEvent

/**
 * Created by wokrey@gmail.com on 8/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface EventHandler {
    fun handleEvent(event: SocketEvent)
}