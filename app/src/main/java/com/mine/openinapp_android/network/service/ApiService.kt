package com.mine.openinapp_android.network.service

import com.mine.openinapp_android.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/dashboardNew")
    suspend fun fetchApiResponse(): ApiResponse

    companion object{
         val BASE_URL = "https://api.inopenapp.com/"
        val TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"
    }

}