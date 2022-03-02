package com.example.nbanews.data.database.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "table_future")
data class FutureMatchEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val team1: String,
    val team1Scores: String,
    val team1Image: String,
    val team2: String,
    val team2Scores: String,
    val team2Image: String,
    val time: String
)