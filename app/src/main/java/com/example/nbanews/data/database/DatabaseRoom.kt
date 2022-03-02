package com.example.nbanews.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nbanews.data.database.model.ClubEntity
import com.example.nbanews.data.database.model.FutureMatchEntity
import com.example.nbanews.data.database.model.NewsLineEntity
import com.example.nbanews.data.database.model.ResultMatchEntity
import com.example.nbanews.data.networkdata.dto.FutureMatchDto

@Database(
    entities = [
        NewsLineEntity::class,
        ClubEntity::class,
        FutureMatchEntity::class,
        ResultMatchEntity::class
    ], version = 3, exportSchema = false
)
abstract class DatabaseRoom : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object {
        val DATABASE_NAME = "application.db"
    }
}