package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.ApiService

interface AmphibianDataRepository {

    suspend fun getAmphibianData():List<Amphibian>

}

class DefaultAmphibianRepository(private val apiService: ApiService):AmphibianDataRepository {
    override suspend fun getAmphibianData(): List<Amphibian> {
        return apiService.getAmphibiansData()
    }

}