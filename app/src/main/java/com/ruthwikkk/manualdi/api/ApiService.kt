package com.ruthwikkk.manualdi.api

import com.ruthwikkk.manualdi.models.Rocket
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/rockets")
    suspend fun getRockets(): List<Rocket>
}