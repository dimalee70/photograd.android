package com.example.photograd.android.extensions

import com.example.photograd.android.Application
import com.example.photograd.android.R
import org.joda.time.DateTime
import org.joda.time.Duration
import java.util.Date

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

inline fun Date.stringTimeDiff(fromDate: Date? = null): String
{
    var from = DateTime.now()
    if (fromDate != null) { from = DateTime(fromDate) }
    val to = DateTime(this)

    val duration = Duration(from, to)

    var days = duration.standardDays

    var hours = duration.standardHours.minus(days * 24)

    var minutes = duration.standardMinutes.minus(duration.standardHours * 60)

    var seconds = duration.standardSeconds.minus(duration.standardMinutes * 60)

    if (days < 0 || hours < 0 || minutes < 0 || seconds < 0)
    {
        days = 0
        hours = 0
        minutes = 0
        seconds = 0
    }

    return Application.appContext.getString(R.string.time_remain,
        String.format("%d", days),
        String.format("%02d", hours),
        String.format("%02d", minutes),
        String.format("%02d", seconds)
    )
}


inline fun Date.shortTimeDiff(fromDate: Date? = null): String
{
    var from = DateTime.now()
    if (fromDate != null) { from = DateTime(fromDate) }
    val to = DateTime(this)
    val duration = Duration(from, to)
    var minutes = duration.standardMinutes.minus(duration.standardHours * 60)
    var seconds = duration.standardSeconds.minus(duration.standardMinutes * 60)

    if (minutes < 0 || seconds < 0)
    {
        minutes = 0
        seconds = 0
    }

    return Application.appContext.getString(R.string.short_time_remain,
        String.format("%02d", minutes),
        String.format("%02d", seconds)
    )
}

inline fun Date.shortDateDiff(fromDate: Date? = null): String
{
    var from = DateTime.now()
    if (fromDate != null) { from = DateTime(fromDate) }
    val to = DateTime(this)
    val duration = Duration(from, to)
    var days = duration.standardDays
    var hours = duration.standardHours.minus(days * 24)

    if (days < 0 || hours < 0)
    {
        days = 0
        hours = 0
    }

    return Application.appContext.getString(
        R.string.short_date_remain,
        String.format("%d", days),
        String.format("%02d", hours)
    )
}

inline fun Date.stringHMSTimeDiff(fromDate: Date? = null): String
{
    var from = DateTime.now()
    if (fromDate != null) { from = DateTime(fromDate) }
    val to = DateTime(this)

    val duration = Duration(from, to)

    var days = duration.standardDays

    var hours = duration.standardHours.minus(days * 24)

    var minutes = duration.standardMinutes.minus(duration.standardHours * 60)

    var seconds = duration.standardSeconds.minus(duration.standardMinutes * 60)

    if (days < 0 || hours < 0 || minutes < 0 || seconds < 0)
    {
        days = 0
        hours = 0
        minutes = 0
        seconds = 0
    }

    return Application.appContext.getString(R.string.time_hms_remain,
        String.format("%02d", hours),
        String.format("%02d", minutes),
        String.format("%02d", seconds)
    )
}
