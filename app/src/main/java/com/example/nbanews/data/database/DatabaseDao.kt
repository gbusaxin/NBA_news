package com.example.nbanews.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nbanews.data.database.model.ClubEntity
import com.example.nbanews.data.database.model.FutureMatchEntity
import com.example.nbanews.data.database.model.NewsLineEntity
import com.example.nbanews.data.database.model.ResultMatchEntity

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM table_news_line")
    fun getNews(): LiveData<List<NewsLineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsLineEntity>)

    @Query("SELECT * FROM table_club")
    fun getClubs(): LiveData<List<ClubEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClubs(clubs: List<ClubEntity>)

    @Query("SELECT * FROM table_future")
    fun getFixtures(): LiveData<List<FutureMatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<FutureMatchEntity>)

    @Query("DELETE FROM table_future")
    suspend fun deleteAllFixtures()

    @Query("SELECT * FROM table_result")
    fun getResults(): LiveData<List<ResultMatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResults(results: List<ResultMatchEntity>)

    @Query("DELETE FROM table_result")
    suspend fun deleteAllResults()

}