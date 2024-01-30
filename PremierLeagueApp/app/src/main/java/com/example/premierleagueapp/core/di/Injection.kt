package com.example.premierleagueapp.core.di

import android.content.Context
import com.example.premierleagueapp.core.data.TeamRepository
import com.example.premierleagueapp.core.data.source.local.LocalDataSource
import com.example.premierleagueapp.core.data.source.local.room.TeamDatabase
import com.example.premierleagueapp.core.data.source.remote.RemoteDataSource
import com.example.premierleagueapp.core.data.source.remote.network.ApiConfig
import com.example.premierleagueapp.core.domain.repository.ITeamRepository
import com.example.premierleagueapp.core.domain.usecase.TeamInteractor
import com.example.premierleagueapp.core.domain.usecase.TeamUseCase
import com.example.premierleagueapp.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ITeamRepository{
        val database = TeamDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.teamDao())
        val appExecutors = AppExecutors()

        return TeamRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTeamUseCase(context: Context): TeamUseCase {
        val repository = provideRepository(context)
        return TeamInteractor(repository)
    }
}