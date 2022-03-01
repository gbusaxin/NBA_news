package com.example.nbanews.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nbanews.data.database.model.ClubEntity
import com.example.nbanews.data.database.model.NewsLineEntity

@Database(
    entities = [
        NewsLineEntity::class,
        ClubEntity::class
    ], version = 2, exportSchema = false
)
abstract class DatabaseRoom : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object {
        val DATABASE_NAME = "application.db"
    }
}