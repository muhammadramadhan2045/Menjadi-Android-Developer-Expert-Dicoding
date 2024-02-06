package com.example.premierleagueapp.di

import com.example.premierleagueapp.core.domain.usecase.TeamInteractor
import com.example.premierleagueapp.core.domain.usecase.TeamUseCase
import com.example.premierleagueapp.detail.DetailViewModel
import com.example.premierleagueapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> {
        TeamInteractor(get())
    }
}

val viewModelModule = module{
    viewModel {HomeViewModel(get())}
    viewModel { DetailViewModel(get()) }
}