package com.example.nbanews.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.nbanews.data.database.converters.ClubConverter
import com.example.nbanews.domain.Composition
import com.example.nbanews.domain.Total

@Entity(tableName = "table_club")
@TypeConverters(ClubConverter::class)
class ClubEntity(
    @PrimaryKey(autoGenerate = false)
    val club: String,
    val clubImage: String,
    val wins: String,
    val fails: String,
    val percent: String,
    val pos: String,
    val composition: List<Composition>,
    val totals: List<Total>
)