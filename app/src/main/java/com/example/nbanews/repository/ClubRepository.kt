package com.example.nbanews.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.nbanews.data.database.DatabaseDao
import com.example.nbanews.data.mappers.ClubMapper
import com.example.nbanews.data.networkdata.RetrofitService
import com.example.nbanews.domain.Club

class ClubRepository constructor(
    private val retrofit: RetrofitService,
    private val database: DatabaseDao,
    private val mapper: ClubMapper
) {

    fun getClubs(): LiveData<List<Club>> {
        return Transformations.map(database.getClubs()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    suspend fun loadClubs() {
        try {
            val dto = retrofit.getClubs()
            Log.d("DTO_CLUB",dto.toString())
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            database.insertClubs(dbModel)
        } catch (e: Exception) {

        }
    }

}