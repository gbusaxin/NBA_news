package com.example.nbanews.data.networkdata

import com.example.nbanews.data.networkdata.dto.ClubDto
import com.example.nbanews.data.networkdata.dto.NewsLineDto
import retrofit2.http.GET

interface RetrofitService {

    @GET("nba_newsline.json")
    suspend fun getNewsLine():List<NewsLineDto>

    @GET("nba_champion_table.json")
    suspend fun getClubs():List<ClubDto>

}