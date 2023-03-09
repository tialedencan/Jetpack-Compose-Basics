package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getAmphibiansData(): List<Amphibian>
}