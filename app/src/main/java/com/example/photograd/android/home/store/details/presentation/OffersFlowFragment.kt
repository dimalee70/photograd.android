package com.example.photograd.android.home.store.details.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentOffersFlowBinding
import com.example.photograd.android.home.store.details.domain.OffersFlowPresenter
import com.example.photograd.android.home.store.details.domain.OffersFlowView
import com.example.photograd.android.utils.BundleConstants
import com.google.android.material.tabs.TabLayout
import moxy.presenter.InjectPresenter

class OffersFlowFragment : BaseFragment(), OffersFlowView {

    lateinit var binding: FragmentOffersFlowBinding

    @InjectPresenter
    lateinit var presenter: OffersFlowPresenter

    private var offersId: ArrayList<Int>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_offers_flow, container, false)
        offersId = arguments?.getIntegerArrayList(BundleConstants.BUNDLE_OFFERS_ID)
        addTabs()
        binding.vpOffers.adapter = OffersPagerAdapter(fm = childFragmentManager, offersId = offersId!!, pagesCount = offersId!!.size)
        binding.vpOffers.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutOffers))

        return binding.root
    }

    private fun addTabs() {
        val titles = arguments?.getStringArrayList(BundleConstants.BUNDLE_OFFERS_TITLES)
        titles?.forEach {
            binding.tabLayoutOffers.addTab(binding.tabLayoutOffers.newTab().setText(it))
        }
    }

}
