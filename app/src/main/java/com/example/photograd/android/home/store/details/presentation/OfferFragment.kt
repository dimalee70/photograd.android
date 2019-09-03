package com.example.photograd.android.home.store.details.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentOfferBinding
import com.example.photograd.android.home.store.details.data.OfferInfo
import com.example.photograd.android.home.store.details.domain.OfferPresenter
import com.example.photograd.android.home.store.details.domain.OfferView
import moxy.presenter.InjectPresenter

private const val BUNDLE_OFFER_ID = "bundle_offer_id"
private const val DEFAULT_OFFER_ID = 0
class OfferFragment : BaseFragment(),OfferView {

    companion object{
        fun newInstance(id: Int) = OfferFragment().apply {
            arguments = Bundle()
            arguments?.putInt(BUNDLE_OFFER_ID, id)
        }
    }

    lateinit var binding: FragmentOfferBinding

    @InjectPresenter
    lateinit var presenter: OfferPresenter

    var offerId:Int = DEFAULT_OFFER_ID

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_offer, container, false)
        getData()

        return binding.root
    }


    override fun showOffersInfo(offerInfo: OfferInfo) {
        binding.info = offerInfo
        binding.notifyChange()
    }

    private fun getData(){
        offerId = arguments?.getInt(BUNDLE_OFFER_ID, DEFAULT_OFFER_ID)!!
        presenter.getOfferInfo(offerId)
    }
}
