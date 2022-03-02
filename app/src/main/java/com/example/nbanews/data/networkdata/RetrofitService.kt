package com.example.nbanews.data.networkdata

import com.example.nbanews.data.networkdata.dto.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET("nba_newsline.json")
    suspend fun getNewsLine():List<NewsLineDto>

    @GET("nba_champion_table.json")
    suspend fun getClubs():List<ClubDto>

    @GET("nba_fixtures.json")
    suspend fun getFixtures():List<FutureMatchDto>

    @GET("nba_results.json")
    suspend fun getResults():List<ResultMatchDto>

    @POST("splash.php")
    suspend fun sendLocale(@Body locale: RequestDto): ResponseDto

}