package com.example.nbanews.di

import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.repository.StartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object StartRepModule {

    @Singleton
    @Provides
    fun provideWebViewRepository(retrofit: RetrofitService): StartRepository {
        return StartRepository(retrofit)
    }
}