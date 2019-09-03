package com.example.photograd.android.home.games.data.model

import androidx.databinding.Bindable
import com.example.photograd.android.BR
import com.example.photograd.android.auth.models.Image
import com.example.photograd.android.auth.models.User
import com.example.photograd.android.extensions.stringTimeDiff
import photograd.kz.photograd.models.enums.MissionType
import java.util.Date

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class PartnerMission(
    var id: Int,
    var reward_apples: Int?,
    var company_resource_link: String?,
    var work_schedule: String?,
    var hashkey: String?,
    var instagram_link: String?,
    var sponsored_by: String?,
    var mission_type: MissionType?,
    val after_activation_text: String?,
    var rewarded_amount: Int?,
    var note: String?,
    var reward_description: String?,
    val objective: Int? = null,
    var due_date: Date?,
    var activation_instructions: String?,
    var description: String?,
    var reward_expiration_date: String,
    var receive_instructions: String?,
    var card_payment: Boolean = false,
    var address: String?,
    var winners_amount: Int?,
    var facebook_link: String?,
    var isUpdated: Boolean = false,
    var selfUserPlace: Int?,
    var imageUrl: String?,
    var imageHash: String?
) : BaseMission() {
    var rewardExpirationDate: String?
        @Bindable get() {
            if (due_date != null) {
                return due_date!!.stringTimeDiff()
            }
            return null
        }
        set(value) {
            notifyPropertyChanged(BR.rewardExpirationDate)
        }

    var topPlayers: ArrayList<User> = ArrayList()

    var topPlayerScores: ArrayList<Int> = ArrayList()

    var userLeftGames: Int? = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.data)
        }
//    var partner: Partner? = null
    var image: Image? = null
    var phones: ArrayList<String> = ArrayList()
}