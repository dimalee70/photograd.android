package com.example.photograd.android.home.ratings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photograd.android.BR
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.custom.RecyclerBindingAdapter
import com.example.photograd.android.databinding.FragmentRatingBinding
import com.example.photograd.android.home.ratings.data.model.RatedUser
import com.example.photograd.android.home.ratings.domain.RatingPresenter
import com.example.photograd.android.home.ratings.domain.RatingView
import moxy.presenter.InjectPresenter


class RatingFragment : BaseFragment(), RatingView {

    companion object{
        const val TAG = "RatingFragment"

        fun newInstance() = RatingFragment()
    }

    lateinit var binding: FragmentRatingBinding
    @InjectPresenter
    lateinit var presenter: RatingPresenter

    private var topRatingAdapter: RecyclerBindingAdapter<RatedUser>? = null
    private var ratingAdapter: RecyclerBindingAdapter<RatedUser>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topRatingAdapter = RecyclerBindingAdapter(R.layout.item_top_rating, BR.user, context!!)
        ratingAdapter = RecyclerBindingAdapter(R.layout.item_rating, BR.user, context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rating, container, false)
        initRecyclers()

        presenter.getRating()
        return binding.root
    }

    override fun showRating(topRating: List<RatedUser>, rating: List<RatedUser>) {
        topRatingAdapter?.setItems(topRating)
        ratingAdapter?.setItems(rating)
    }

    private fun initRecyclers(){
        binding.rvTopRating.adapter = topRatingAdapter
        binding.rvTopRating.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)

        binding.rvRating.adapter = ratingAdapter
        binding.rvRating.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
    }
}
