package com.example.premierleagueapp.core.di

import androidx.room.Room
import com.example.premierleagueapp.core.data.TeamRepository
import com.example.premierleagueapp.core.data.source.local.LocalDataSource
import com.example.premierleagueapp.core.data.source.local.room.TeamDatabase
import com.example.premierleagueapp.core.data.source.remote.RemoteDataSource
import com.example.premierleagueapp.core.data.source.remote.network.ApiService
import com.example.premierleagueapp.core.domain.repository.ITeamRepository
import com.example.premierleagueapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule= module {
    factory {
        get<TeamDatabase>().teamDao()
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            TeamDatabase::class.java, "Team.db"
        ).fallbackToDestructiveMigration().build()
    }

}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)

    }

}

val repositoryModule = module{
    single {
        LocalDataSource(get())
    }
    single {
        RemoteDataSource(get())
    }
    single {
        AppExecutors()
    }
    single<ITeamRepository> {
        TeamRepository(get(), get(), get())
    }
}