package com.dicoding.tourismapp.core.data.source.remote.network

import com.dicoding.tourismapp.core.data.source.remote.response.ListTourismResponse

import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("list")
    fun getList(): Call<ListTourismResponse>
}