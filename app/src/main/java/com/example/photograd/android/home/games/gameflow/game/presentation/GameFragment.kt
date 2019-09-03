package com.example.photograd.android.home.games.gameflow.game.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentGameBinding
import com.example.photograd.android.home.games.gameflow.game.domain.GamePresenter
import com.example.photograd.android.home.games.gameflow.game.domain.GameView
import moxy.presenter.InjectPresenter


class GameFragment : BaseFragment(), GameView {

    companion object {
        const val TAG: String = "GameFragment"
        fun newInstance() = GameFragment()
    }


    @InjectPresenter
    lateinit var presenter: GamePresenter

    lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        binding.presenter = presenter
        return binding.root
    }


}
