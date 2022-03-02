package com.example.nbanews.data.database.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.nbanews.data.database.converters.NewsLineConverter
import com.example.nbanews.domain.Publication
@Keep
@Entity(tableName = "table_news_line")
@TypeConverters(NewsLineConverter::class)
data class NewsLineEntity(
    @PrimaryKey(autoGenerate = false)
    val date: String,
    val publications: List<Publication>
)