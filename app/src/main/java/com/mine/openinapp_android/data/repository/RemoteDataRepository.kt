package com.mine.openinapp_android.data.repository

import com.mine.openinapp_android.network.model.ApiResponse

interface RemoteDataRepository {
    suspend fun getData():ApiResponse
}