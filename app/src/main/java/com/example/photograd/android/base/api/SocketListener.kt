package photograd.kz.photograd.api

import android.util.Log
import com.example.photograd.android.utils.DataHolder
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString


/**
 * Created by wokrey@gmail.com on 7/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class SocketListener: WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        Log.e(javaClass.name, "socket is opened")
        SocketEventsManager.isClosed = false
        super.onOpen(webSocket, response)
    }

    override fun onFailure(webSocket: WebSocket, throwable: Throwable, response: Response?) {
        SocketEventsManager.handleError(error = throwable, response = response)
        SocketEventsManager.isClosed = true
        SocketEventsManager.wasLogged = !DataHolder.sessionid.isNullOrBlank()
        Log.e(javaClass.name, "socket is fail: ${throwable}, message: ${throwable.message}, response: ${response?.body()}")
        super.onFailure(webSocket, throwable, response)
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
       super.onClosing(webSocket, code, reason)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        SocketEventsManager.handleMessage(message = text)
        super.onMessage(webSocket, text)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        SocketEventsManager.clearMaps()
        SocketEventsManager.isClosed = true
        SocketEventsManager.wasLogged = !DataHolder.sessionid.isNullOrBlank()
        Log.e(javaClass.name, "socket is closed:$reason")
        super.onClosed(webSocket, code, reason)
    }
}