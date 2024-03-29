package com.example.premierleagueapp.di

import com.example.premierleagueapp.core.domain.usecase.TeamInteractor
import com.example.premierleagueapp.core.domain.usecase.TeamUseCase
import com.example.premierleagueapp.detail.DetailViewModel
import com.example.premierleagueapp.home.HomeViewModel
import com.example.premierleagueapp.setting.SettingPreferences
import com.example.premierleagueapp.setting.SettingViewModel
import com.example.premierleagueapp.setting.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> {
        TeamInteractor(get())
    }

}

val prefModule = module {
    factory {
        SettingPreferences.getInstance(androidContext().applicationContext.dataStore)
    }
}

val viewModelModule = module{
    viewModel {HomeViewModel(get())}
    viewModel { DetailViewModel(get()) }
    viewModel { SettingViewModel(get()) }
}