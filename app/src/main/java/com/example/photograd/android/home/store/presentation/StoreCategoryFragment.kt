package com.example.photograd.android.home.store.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photograd.android.BR

import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.custom.RecyclerBindingAdapter
import com.example.photograd.android.databinding.FragmentStoreCategoryBinding
import com.example.photograd.android.home.store.data.model.Offer
import com.example.photograd.android.home.store.domain.StoreCategoryPresenter
import com.example.photograd.android.home.store.domain.StoreCategoryView
import com.example.photograd.android.utils.BundleConstants
import moxy.presenter.InjectPresenter


private const val CATEGORY_ID = "category_id"

class StoreCategoryFragment : BaseFragment(), StoreCategoryView, RecyclerBindingAdapter.OnItemClickListener<Offer> {

    companion object {
        const val TAG: String = "StoreCategoryFragment"

        fun newInstance(id: Int) = StoreCategoryFragment().apply {
            arguments = Bundle()
            arguments?.putInt(CATEGORY_ID, id)
        }
    }

    lateinit var binding: FragmentStoreCategoryBinding
    @InjectPresenter
    lateinit var presenter: StoreCategoryPresenter
    private var offersAdapter: RecyclerBindingAdapter<Offer>? = null
    private var categoryId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        offersAdapter = RecyclerBindingAdapter(R.layout.item_offer, BR.offer, context!!)
        offersAdapter?.setOnItemClickListener(onItemClickListener = this)
        categoryId = arguments?.getInt(CATEGORY_ID)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store_category, container, false)
        binding.rvOffers.adapter = offersAdapter
        binding.rvOffers.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)

        presenter.getCategoryOffers(categoryId)
        return binding.root
    }

    override fun showOffers(offers: List<Offer>) {
        val observList = ObservableArrayList<Offer>()
        observList.addAll(offers)
        offersAdapter?.setItems(items = observList)
        offersAdapter?.notifyDataSetChanged()
    }

    override fun onItemClick(position: Int, item: Offer) {
        val titleList: ArrayList<String?> = ArrayList(presenter.data?.size ?: 0)
        val idList: ArrayList<Int?> = ArrayList(presenter.data?.size ?: 0)

        presenter.data?.forEach {
            titleList.add(it.title)
            idList.add(it.id)
        }
        val args = bundleOf(
            BundleConstants.BUNDLE_OFFERS_TITLES to titleList,
            BundleConstants.BUNDLE_OFFERS_ID to idList
        )

        activity.navController.navigate(R.id.offersFlow, args)
    }
}
