package com.example.myreactivesearch.network

import com.example.myreactivesearch.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("geocoding/{query}.json")
    suspend fun getPlaces(
        @Path("query") query: String,
        @Query("key") key: String,
    ): PlaceResponse
}