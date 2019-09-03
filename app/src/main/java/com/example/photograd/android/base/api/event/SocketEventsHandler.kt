package photograd.kz.photograd.api.event

import com.example.photograd.android.auth.models.User
import com.example.photograd.android.base.models.SocketBusEvent
import com.google.gson.Gson
import org.greenrobot.eventbus.EventBus
import photograd.kz.photograd.api.event.handlers.EventHandler
import photograd.kz.photograd.models.SocketEvent

/**
 * Created by wokrey@gmail.com on 8/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

private const val OFFER = "Offer"
private const val USER = "User"
private const val PARTNER_MISSION = "PartnerMission"

class SocketEventsHandler(
    private val parser: Gson
) : EventHandler {

    override fun handleEvent(event: SocketEvent) =  post(
        SocketBusEvent(
            value = parser.fromJson(
                parser.toJson(event.data),
                getJavaClass(event.classname)
            ),
            object_id = event.object_id,
            field_name = event.field_name,
            field_value = event.field_value,
            type = event.type
        )
    )

    private fun <T> post(event: SocketBusEvent<T>) = EventBus.getDefault().post(event)

    private fun getJavaClass(classname: String): Class<*> = when(classname) {
      /*  OFFER -> Offer::class.java
        USER -> User::class.java
        PARTNER_MISSION -> PartnerMission::class.java*/
        else -> Any::class.java
    }
}