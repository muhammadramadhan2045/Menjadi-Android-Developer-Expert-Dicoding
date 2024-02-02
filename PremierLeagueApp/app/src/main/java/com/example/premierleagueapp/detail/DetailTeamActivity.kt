package com.example.premierleagueapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.premierleagueapp.R
import com.example.premierleagueapp.core.domain.model.Team
import com.example.premierleagueapp.databinding.ActivityDetailTeamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTeamActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private  val detailViewModel: DetailViewModel by viewModel()
    private var binding: ActivityDetailTeamBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbar)

        val detailTeam= intent.getParcelableExtra<Team>(EXTRA_DATA)
        showDetailTeam(detailTeam)
    }

    private fun showDetailTeam(detailTeam: Team?) {
        detailTeam?.let {
            supportActionBar?.title = detailTeam.strTeam
            binding?.content?.tvDetailDescription?.text = detailTeam.strDescriptionEN
            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.strTeamBadge)
                .into(binding?.ivDetailImage!!)

            var statusFavorite = detailTeam.isFavorite
            setStatusFavorite(statusFavorite)
            binding?.fab?.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }

    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding?.fab?.setImageResource(R.drawable.ic_favorite_white)
        } else {
            binding?.fab?.setImageResource(R.drawable.ic_not_favorite_white)
        }
    }


}