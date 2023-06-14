package com.mine.openinapp_android.di

import com.mine.openinapp_android.data.repository.RemoteDataRepository
import com.mine.openinapp_android.data.repository.RemoteDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindsDataRepository(remoteDataRepositoryImpl: RemoteDataRepositoryImpl):RemoteDataRepository
}