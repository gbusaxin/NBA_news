package com.example.nbanews.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.NewsLineMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.domain.NewsLine

class NewsLineRepository constructor(
    private val dao: DatabaseDao,
    private val retrofitService: RetrofitService,
    private val mapper: NewsLineMapper
) {

    fun getNewsLine(): LiveData<List<NewsLine>> {
        return Transformations.map(dao.getNews()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    suspend fun loadNewsLine() {
        try {
            val dto = retrofitService.getNewsLine()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            Log.d("CHECK_DOWN",dbModel.toString())
            dao.insertNews(dbModel)
        } catch (e: Exception) {

        }
    }

}