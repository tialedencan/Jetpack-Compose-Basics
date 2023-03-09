package com.example.amphibians.data

import com.example.amphibians.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AppContainer {
    val amphibianDataRepository: AmphibianDataRepository
}
class DefaultAppContainer : AppContainer {

    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com/amphibians"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()


    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val amphibianDataRepository: AmphibianDataRepository by lazy {
        DefaultAmphibianRepository(retrofitService)
    }
}