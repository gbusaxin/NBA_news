package com.example.nbanews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.FutureMapper
import com.example.nbanews.data.mappers.ResultMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.domain.FutureMatch
import com.example.nbanews.domain.ResultMatch

class MatchesRepository(
    private val retrofit: RetrofitService,
    private val database: DatabaseDao,
    private val resultMapper: ResultMapper,
    private val futureMapper: FutureMapper
) {

    fun getResults(): LiveData<List<ResultMatch>> {
        return Transformations.map(database.getResults()) {
            it.map { resultMapper.mapDbModelToEntity(it) }
        }
    }

    fun getFixtures(): LiveData<List<FutureMatch>> {
        return Transformations.map(database.getFixtures()) {
            it.map { futureMapper.mapDbModelToEntity(it) }
        }
    }

    suspend fun deleteAllResults(){
        database.deleteAllResults()
    }

    suspend fun deleteAllFixtures() {
        database.deleteAllFixtures()
    }

    suspend fun loadResult() {
        try {
            val dto = retrofit.getResults()
            val dbModel = dto.map { resultMapper.mapDtoToDbModel(it) }
            database.insertResults(dbModel)
        } catch (e: Exception) {

        }
    }

    suspend fun loadFixtures() {
        try {
            val dto = retrofit.getFixtures()
            val dbModel = dto.map { futureMapper.mapDtoToDbModel(it) }
            database.insertFixtures(dbModel)
        } catch (e: Exception) {

        }
    }
}