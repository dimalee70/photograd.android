package com.example.photograd.android.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentHomeFlowBinding
import com.example.photograd.android.home.data.model.NamedPagerElements
import com.example.photograd.android.home.data.model.OfferCategory
import com.example.photograd.android.home.domain.HomeFlowPresenter
import com.example.photograd.android.home.domain.HomeFlowView
import com.example.photograd.android.home.games.presentation.CurrentGamesFragment
import com.example.photograd.android.home.games.presentation.MissionsFragment
import com.example.photograd.android.home.ratings.presentation.FriendsRatingFragment
import com.example.photograd.android.home.ratings.presentation.RatingFragment
import com.example.photograd.android.home.store.presentation.StoreCategoryFragment
import com.example.photograd.android.utils.DataHolder
import com.google.android.material.tabs.TabLayout
import moxy.presenter.InjectPresenter

private const val MIN_PAGES_COUNT = 6 //missions, duels, statistics, history, friends rating, top rating,

class HomeFlowFragment : BaseFragment(), HomeFlowView, Tagger {

    companion object {
        const val TAG: String = "HomeFlowFragment"

        fun newInstance() = HomeFlowFragment()
    }

    lateinit var binding: FragmentHomeFlowBinding

    private var namedPagesList: ArrayList<NamedPagerElements>? = null

    @InjectPresenter
    lateinit var presenter: HomeFlowPresenter


    private var pagesCount: Int = MIN_PAGES_COUNT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home_flow,
            container,
            false
        )
        presenter.getStoreCategories()
        showBottomNavigation()

        return binding.root
    }

    override fun initViewPager(categories: List<OfferCategory>) {
        addTabs(
            categories = categories,
            hasCurrentGames = DataHolder.hasCurrentGame,
            hasPurchases = DataHolder.hasPurchases
        )
        binding.vpMain.adapter = HomeViewPagerAdapter(childFragmentManager, pagesCount = pagesCount, tagger = this)
        binding.vpMain.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutMain))
    }

    override fun getTag(position: Int): String? {
        if (namedPagesList!!.size-1 < position){
            return null
        }
        return namedPagesList?.get(position)?.tag
    }

    override fun getId(position: Int): Int? {
        if (namedPagesList!!.size-1 < position){
            return null
        }
        return namedPagesList?.get(position)?.categoryId
    }

    private fun addTabs(categories: List<OfferCategory>, hasCurrentGames: Boolean, hasPurchases: Boolean) {
        namedPagesList = ArrayList()
        if (hasPurchases) {
            pagesCount++
        }
        if (hasCurrentGames) {
            pagesCount++
            binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_current_games))
            addPagerElement(CurrentGamesFragment.TAG)
        }
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_duels))
        addPagerElement(MissionsFragment.TAG)

        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_missions))
        addPagerElement(MissionsFragment.TAG)

        pagesCount += categories.size

        for (i in categories.indices) {
            binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(categories[i].title))
            addPagerElement(tag = StoreCategoryFragment.TAG, id = categories[i].id)
        }

        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_top_rating))
        addPagerElement(RatingFragment.TAG)
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_friends_rating))
        addPagerElement(FriendsRatingFragment.TAG)

        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_achievements))
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText(R.string.tab_games_history))
    }

    private fun addPagerElement(tag: String) {
        addPagerElement(tag = tag, id = null)
    }

    private fun addPagerElement(tag: String, id: Int?) {
        namedPagesList?.add(NamedPagerElements(tag = tag, categoryId = id))
    }

    private fun showBottomNavigation() {
        var videoFragment =
            childFragmentManager.findFragmentById(R.id.bottom_nav_container) as BottomNavigationFragment?

        if (videoFragment == null) {
            videoFragment =
                BottomNavigationFragment.newInstance()

            childFragmentManager
                .beginTransaction()
                .add(R.id.bottom_nav_container, videoFragment)
                .commit()
        }
    }


}
