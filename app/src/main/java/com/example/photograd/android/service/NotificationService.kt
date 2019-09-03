package com.example.photograd.android.service

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import com.example.photograd.android.base.models.InGameNotification
import com.example.photograd.android.base.models.InGameNotificationData
import com.example.photograd.android.utils.Constants

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

import android.preference.PreferenceManager
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.onesignal.NotificationExtenderService
import com.onesignal.OSNotificationReceivedResult
import photograd.kz.photograd.models.enums.NotificationType
import java.math.BigInteger


class NotificationService : NotificationExtenderService() {
    private val gson = Gson()
    private val type = object : TypeToken<InGameNotificationData>() {}.type

    override fun onNotificationProcessing(receivedResult: OSNotificationReceivedResult): Boolean {

        Log.d("NotificationService","new notification")
        if (receivedResult.payload?.additionalData == null)
        {
            showNotification()
            return true
        }

        val data = receivedResult.payload.additionalData.toString()
        val notificationData = gson.fromJson<InGameNotificationData>(data, type)

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(applicationContext)
/*
        try {
            var noti: InGameNotification? = null

            if (notificationData.notification_id == null) {
                noti = InGameNotification(
                    0,
                    notificationData.notification_type,
                    notificationData.notification_type == NotificationType.MARKETING_PUSH,
                    notificationData,
                    notificationData.notification_type == NotificationType.MARKETING_PUSH,
                    sharedPref.getInt(Constants.userIdPrefsKey, -1)
                )
            } else {
                noti = InGameNotification(
                    notificationData.notification_id.toLong(),
                    notificationData.notification_type,
                    notificationData.notification_type == NotificationType.MARKETING_PUSH,
                    notificationData,
                    notificationData.notification_type == NotificationType.MARKETING_PUSH,
                    sharedPref.getInt(Constants.userIdPrefsKey, -1)
                )
                //receivedResult.isAppInFocus
                Log.d("NotificationService","pass to NotificationManager")
                NotificationManagerCompat.addNotifications(listOf(noti))
            }

            when (noti.type) {
                NotificationType.CHALLENGE_DECLINED -> return true
                //NotificationType.GAME_FINISHED -> return true
                NotificationType.ACHIEVEMENT_RECIEVED -> return true
                //NotificationType.MISSION_COMPLETED -> return true
                NotificationType.PARTNER_MISSION_LOOSE -> return true
                NotificationType.CHALLENGE -> return true
                NotificationType.CHALLENGE_FRIEND -> return true
                NotificationType.FRIENDSHIP_REQUEST -> return true
                NotificationType.FRIENDSHIP_REQUEST_ANSWER -> return true
                NotificationType.MARKETING_PUSH -> {
                    showNotification()
                    return true
                }
            }

            if (!receivedResult.isAppInFocus) {
                showNotification()
            }*/

     /*   }
        catch (e:Exception)
        {
            Log.e("NotificationService", "Error", e)
        }
*/
        return true
    }

    private fun showNotification()
    {
        val overrideSettings = NotificationExtenderService.OverrideSettings()
        overrideSettings.extender = NotificationCompat.Extender { builder ->
            builder.setColor(BigInteger("4696f2", 16).toInt())
            //.setSmallIcon(R.drawable.app_icon)
            // .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.app_icon))
        }

        val displayedResult = displayNotification(overrideSettings)
    }
}