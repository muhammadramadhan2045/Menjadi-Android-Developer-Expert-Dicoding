package com.example.premierleagueapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.premierleagueapp.core.di.Injection
import com.example.premierleagueapp.core.domain.usecase.TeamUseCase
import com.example.premierleagueapp.detail.DetailViewModel
import com.example.premierleagueapp.favorite.FavoriteViewModel
import com.example.premierleagueapp.home.HomeViewModel

class ViewModelFactory private constructor(private val teamUseCase: TeamUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideTeamUseCase(
                                context
                            )
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when{
            modelClass.isAssignableFrom(HomeViewModel::class.java)->{
                HomeViewModel(teamUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java)->{
                FavoriteViewModel(teamUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java)->{
                DetailViewModel(teamUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}