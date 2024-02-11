package com.example.premierleagueapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.premierleagueapp.R
import com.example.premierleagueapp.core.domain.model.Team
import com.example.premierleagueapp.core.ui.ImageAdapter
import com.example.premierleagueapp.databinding.FragmentAboutTeamBinding
import com.example.premierleagueapp.detail.DetailTeamActivity.Companion.EXTRA_DATA
import org.koin.androidx.viewmodel.ext.android.viewModel


class AboutTeamFragment : Fragment() {

    private var _binding: FragmentAboutTeamBinding? = null
    private val binding get() = _binding!!

    val detailViewModel: DetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailTeam = activity?.intent?.getParcelableExtra<Team>(EXTRA_DATA)

        val imageUrl= listOf(
            detailTeam!!.strTeamFanart1,
            detailTeam.strTeamFanart2,
            detailTeam.strTeamFanart3,
            detailTeam.strTeamFanart4,
            detailTeam.strStadiumThumb

        )

        val adapter = ImageAdapter(imageUrl)

        binding.apply {
            tvStadiumDesc.text = detailTeam.strDescriptionEN
            tvStadium.text = detailTeam.strStadium
            tvStadiumLocation.text = detailTeam.strStadiumLocation
            tvStadiumCapacity.text = detailTeam.intStadiumCapacity
            tvLeagueName.text = detailTeam.strLeague
            tvEstablished.text = detailTeam.intFormedYear

        }

        binding.rvImage.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            this.adapter = adapter
            adapter.notifyDataSetChanged()

        }
    }


}