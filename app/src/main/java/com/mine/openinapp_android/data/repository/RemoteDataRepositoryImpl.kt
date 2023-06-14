package com.mine.openinapp_android.data.repository

import com.mine.openinapp_android.network.model.ApiResponse
import com.mine.openinapp_android.network.service.ApiService
import javax.inject.Inject

class RemoteDataRepositoryImpl @Inject constructor(private val apiService: ApiService) : RemoteDataRepository {
    override suspend fun getData(): ApiResponse {
        val response = apiService.fetchApiResponse()
        return response
    }
}