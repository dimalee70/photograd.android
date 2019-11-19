package com.example.photograd.android.home.games.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.example.photograd.android.R
import com.example.photograd.android.auth.models.User
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.custom.RecyclerBindingAdapter
import com.example.photograd.android.databinding.FragmentDuelsBinding
import com.example.photograd.android.home.games.data.model.Friend
import com.example.photograd.android.home.games.data.model.FriendsModel
import com.example.photograd.android.home.games.data.model.UserShort
import com.example.photograd.android.home.games.domain.DuelsPresenter
import com.example.photograd.android.home.games.domain.DuelsView
import moxy.presenter.InjectPresenter


class DuelsFragment : BaseFragment(), DuelsView {

    companion object{
        const val TAG: String = "DuelsFragment"
        fun newInstance() = DuelsFragment()
    }

    lateinit var binding: FragmentDuelsBinding

    var friendsRequest: ObservableArrayList<UserShort> = ObservableArrayList()

    var friends: ObservableArrayList<UserShort> = ObservableArrayList()

    @InjectPresenter
    lateinit var presenter: DuelsPresenter

    lateinit var recyclerFriendAdapter: RecyclerBindingAdapter<Any>

//    lateinit var recyclerFriendRequestAdapter: RecyclerBindingAdapter<UserShort>

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerFriendAdapter = RecyclerBindingAdapter(R.layout.item_duel, BR.data, context!!)
//        recyclerFriendRequestAdapter = RecyclerBindingAdapter(R.layout.item_duel, BR.data, context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_duels, container,
            false)
        binding.presenter = presenter
        presenter.attachLifecycle(lifecycleRegistry)
        presenter.observeForFriendsResponseBoundary()
            .observe(this, Observer {
                response -> response.let {
                setFriends(response)
            }
            })
        binding.friendsRv.adapter = recyclerFriendAdapter
//        binding.friendsRequestRv.adapter = recyclerFriendRequestAdapter
        presenter.getFriends()
        return binding.root
    }

    fun setFriends(response: FriendsModel){
//        if (response.friends.isNotEmpty()){
        friends.addAll(response.friends)
        friends.add(null)
//        friends.add(UserShort(1, "1",1, "1", true, 1, "1"))
//        friends.add(null)
        friends.addAll(response.requests)
        recyclerFriendAdapter.setItems(friends)
//        }
//        friendsRequest.addAll(response.requests)
//        recyclerFriendRequestAdapter.setItems(friendsRequest)
    }
}
