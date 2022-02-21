package com.example.nbanews.di

import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.NewsLineMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.repository.NewsLineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsLineRepModule {

    @Singleton
    @Provides
    fun provideNewsLineRep(
        database: DatabaseDao,
        retrofit: RetrofitService,
        mapper: NewsLineMapper
    ): NewsLineRepository {
        return NewsLineRepository(database, retrofit, mapper)
    }

}