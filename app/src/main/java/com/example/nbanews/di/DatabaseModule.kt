package com.example.nbanews.di

import android.content.Context
import androidx.room.Room
import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.database.DatabaseRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseRoom(@ApplicationContext context: Context): DatabaseRoom {
        return Room.databaseBuilder(
            context,
            DatabaseRoom::class.java,
            DatabaseRoom.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDatabaseDao(database: DatabaseRoom): DatabaseDao {
        return database.databaseDao()
    }

}