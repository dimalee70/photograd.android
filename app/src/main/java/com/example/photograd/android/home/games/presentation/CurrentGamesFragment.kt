package com.example.photograd.android.home.games.presentation


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
import com.example.photograd.android.databinding.FragmentCurrentGamesBinding
import com.example.photograd.android.home.games.data.model.Game
import com.example.photograd.android.home.games.domain.CurrentGamesPresenter
import com.example.photograd.android.home.games.domain.CurrentGamesView
import moxy.presenter.InjectPresenter

class CurrentGamesFragment : BaseFragment(),CurrentGamesView, RecyclerBindingAdapter.OnItemClickListener<Game> {

    companion object{
        const val TAG: String = "CurrentGamesFragment"
        fun newInstance() = CurrentGamesFragment()
    }

    @InjectPresenter
    lateinit var presenter: CurrentGamesPresenter

    lateinit var binding: FragmentCurrentGamesBinding
    private lateinit var gamesAdapter: RecyclerBindingAdapter<Game>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gamesAdapter = RecyclerBindingAdapter(
            R.layout.item_current_game,
            BR.game,
            context!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_current_games,
            container,
            false
        )
        gamesAdapter.setOnItemClickListener(this)
        binding.rvCurrentGames.adapter = gamesAdapter
        binding.rvCurrentGames.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        gamesAdapter.setItems(listOf(
            Game(),
            Game()
        ))
        gamesAdapter.notifyDataSetChanged()

        return binding.root
    }

    override fun onItemClick(position: Int, item: Game) {
        activity.navController.navigate(R.id.gameFlowFragment)
    }
}
