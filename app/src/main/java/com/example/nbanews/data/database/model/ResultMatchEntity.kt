package com.example.nbanews.data.database.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "table_result")
data class ResultMatchEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val team1: String,
    val team1Image: String,
    val team1Score: String,
    val team1Result: String,
    val team2: String,
    val team2Image: String,
    val team2Score: String,
    val team2Result: String
)