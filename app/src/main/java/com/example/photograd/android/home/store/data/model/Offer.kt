package com.example.photograd.android.home.store.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.photograd.android.BR
import com.example.photograd.android.auth.models.Image
import com.example.photograd.android.extensions.stringTimeDiff
import photograd.kz.photograd.models.enums.RestrictionType

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class Offer(
    var phones:List<String>?,
    var company_resource_link: String?,
    var work_schedule: String?,
    var hashkey: String?,
    var instagram_link: String?,
    var id: Int,
    var title: String?,
    var after_activation_text: String?,
    var company_id: Int,
    var note: String?,
    var initial_amount: Int?,
    var company_name: String?,
    var image: Image?,
    var status: Int?,
    var activation_instructions: String?,
    var description: String?,
    var price: Int,
    var receive_instructions: String?,
    var card_payment: Boolean = false,
    var purchase_days_valid: Int?,
    var address: String?,
    var facebook_link: String?,
    var current_amount: Int,
    var date_created: String,
    var order_number: Int = -1,
    var deposit: String = "",
    var restrictions: Restriction?

): BaseObservable(){
    var nextAvailableLeftTime: String?
        @Bindable get() {

            return restrictions?.next_purchase_available_at?.stringTimeDiff()
        }
        set(value) {
            notifyPropertyChanged(BR.nextAvailableLeftTime)
        }

    var hasTimer: Boolean
        @Bindable get() {

            return restrictions?.next_purchase_available_at != null
        }
        set(value) {
            notifyPropertyChanged(BR.nextAvailableLeftTime)
        }

    fun getRestrictionType(): RestrictionType {
        if (!deposit.isBlank()) {

            return RestrictionType.DEPOSIT
        }
        if (deposit.isBlank() && restrictions == null) {

            return RestrictionType.NO_RESTRICTION
        }

        if (restrictions?.purchases_left == null) {

            return RestrictionType.PERIOD_RESTRICTION
        }

        if (restrictions?.period == null){

            return RestrictionType.TOTAL_RESTRICTION
        }

        return RestrictionType.TOTAL_AND_PERIOD_RESTRICTION
    }
}