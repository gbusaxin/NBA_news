package com.example.nbanews.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nbanews.data.database.model.NewsLineEntity

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM table_news_line")
    fun getNews(): LiveData<List<NewsLineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsLineEntity>)

}