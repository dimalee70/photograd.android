package com.example.photograd.android.home.games.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.example.photograd.android.BR
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.custom.RecyclerBindingAdapter
import com.example.photograd.android.databinding.FragmentMissionsBinding
import com.example.photograd.android.home.games.data.model.BaseMission
import com.example.photograd.android.home.games.data.model.MissionsData
import com.example.photograd.android.home.games.data.model.PartnerMission
import com.example.photograd.android.home.games.data.model.PhotogradMission
import com.example.photograd.android.home.games.domain.MissionsPresenter
import com.example.photograd.android.home.games.domain.MissionsView
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.bind
import photograd.kz.photograd.models.enums.MissionType

class MissionsFragment : BaseFragment(), MissionsView {
    companion object {
        const val TAG: String = "MissionsFragment"
        fun newInstance() = MissionsFragment()
    }

    lateinit var binding: FragmentMissionsBinding

    @InjectPresenter
    lateinit var presenter: MissionsPresenter

    var missions: ObservableArrayList<BaseMission> = ObservableArrayList()

    lateinit var recyclerMissionsAdapter: RecyclerBindingAdapter<BaseMission>

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerMissionsAdapter = RecyclerBindingAdapter(R.layout.item_photograd_mission, BR.mission, context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_missions, container, false)
        binding.presenter = presenter
        presenter.attachLifecycle(lifecycleRegistry)
        presenter.observeForMissionsResponseBoundary()
            .observe(this, Observer {
                response -> response.let {
                setMissions(response)
            }
            })
        binding.rvMissions.adapter = recyclerMissionsAdapter
        presenter.getMission()
        return binding.root
    }

    fun setMissions(response: MissionsData){
//        var p1 = PartnerMission(1,1,"ss","ww", "ii", "qq",
//            null, null, null, null, null, null,
//            null, null, null, null, "12", null,
//            true, null, null, null, true, null, null,
//            null)
//        missions.add(p1)
//        var m = PhotogradMission(2, 10, null, 2 ,5, false, 19, 20);
//        missions.add(m)
        missions.addAll(response.missions)
        missions.addAll(response.partner_missions)
        recyclerMissionsAdapter.setItems(missions)
    }


}
