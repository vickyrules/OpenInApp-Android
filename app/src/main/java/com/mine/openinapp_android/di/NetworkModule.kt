package com.mine.openinapp_android.di

import com.mine.openinapp_android.network.service.ApiService
import com.mine.openinapp_android.network.service.ApiService.Companion.BASE_URL
import com.mine.openinapp_android.network.service.ApiService.Companion.TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer ${TOKEN}")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }.build()

        return client
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
