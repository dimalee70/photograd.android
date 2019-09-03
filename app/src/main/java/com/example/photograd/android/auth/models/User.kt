package com.example.photograd.android.auth.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.photograd.android.BR
import com.example.photograd.android.utils.Constants
import photograd.kz.photograd.models.enums.UserStatus
import java.util.Date

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class User(
    var id: Int,
    var username: String,
    var rank: Int,
    var hashkey: String? = null,
    var isUpdated: Boolean = false,
    var gamesToRankLeft: Int? = null,
    var place: Int = -1,
    var victories: Int = 0,
    var special_status: Int = 0,
    var energy: Int? = null,
    var next_energy_refill_time: Date? = null,
    var avatar: Image? = null,
    var apples: Int? = null,
    var status: UserStatus? = null,
    var rating: Double = 0.0,
    var right_answers_percentage: Double? = null
): BaseObservable(){
    var trueCitiezen: Boolean = false
        @Bindable get() {
            if (right_answers_percentage == null) {
                return false
            }
            return right_answers_percentage!! >= Constants.trueAlmatyCitizenThreshold
        }

    var birthday: String? = null
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.birthday)
        }

    var email: String? = null
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    var gender: Int = 0
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender) // <=== PROBLEM!!
        }
}