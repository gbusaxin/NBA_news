package com.example.nbanews.di

import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.FutureMapper
import com.example.nbanews.data.mappers.ResultMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.repository.MatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchesRepModule {

    @Singleton
    @Provides
    fun provideMatchRep(
        retrofitService: RetrofitService,
        databaseDao: DatabaseDao,
        futureMapper: FutureMapper,
        resultMapper: ResultMapper
    ): MatchesRepository {
        return MatchesRepository(retrofitService, databaseDao, resultMapper, futureMapper)
    }
}