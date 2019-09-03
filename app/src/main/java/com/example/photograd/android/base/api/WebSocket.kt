package photograd.kz.photograd.api

import com.example.photograd.android.BuildConfig
import com.example.photograd.android.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.concurrent.TimeUnit

/**
 * Created by wokrey@gmail.com on 7/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
object WebSocket {
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(Constants.readTimeout, TimeUnit.SECONDS)
        .writeTimeout(Constants.writeTimeout, TimeUnit.SECONDS)
        .pingInterval(Constants.PING_INTERFAL, TimeUnit.SECONDS)
        .connectTimeout(Constants.connectTimeout, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    private val listener = SocketListener()

    private val request: Request = Request.Builder()
        .url(
            if (BuildConfig.FLAVOR == Constants.DEVELOPMENT_FLAVOR) {
                Constants.WS_TEST_ENDPOINT
            } else {
                Constants.WS_ENDPOINT
            }
        )
        .build() as Request

    var ws: WebSocket = client.newWebSocket(request, listener)

    fun send(jsonStr: String) = ws.send(jsonStr)
    fun close(code: Int, reason: String) = ws.close(code, reason)

    fun connect() {
        ws = client.newWebSocket(request, listener)
    }
}