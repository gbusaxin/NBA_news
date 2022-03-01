package com.example.nbanews.di

import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.ClubMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.repository.ClubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClubRepModel {

    @Singleton
    @Provides
    fun provideClubRepModel(
        database: DatabaseDao,
        retrofit: RetrofitService,
        mapper: ClubMapper
    ): ClubRepository {
        return ClubRepository(
            retrofit, database, mapper
        )
    }
}