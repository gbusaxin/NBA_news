package com.example.nbanews.data.mappers

import com.example.nbanews.data.database.model.FutureMatchEntity
import com.example.nbanews.data.networkdata.dto.FutureMatchDto
import com.example.nbanews.domain.FutureMatch
import com.example.nbanews.util.PatternMapper
import javax.inject.Inject

class FutureMapper @Inject constructor() :
    PatternMapper<FutureMatch, FutureMatchDto, FutureMatchEntity> {
    override fun mapDtoToDbModel(dto: FutureMatchDto) = FutureMatchEntity(
        id = 0,
        team1 = dto.team1?:"",
        team1Image = dto.team1Image?:"",
        team1Scores = dto.team1Scores?:"",
        team2 = dto.team2?:"",
        team2Image = dto.team2Image?:"",
        team2Scores = dto.team2Scores?:"",
        time = dto.time?:""
    )

    override fun mapDbModelToEntity(dbModel: FutureMatchEntity) = FutureMatch(
        team1 = dbModel.team1,
        team1Image = dbModel.team1Image,
        team1Scores = dbModel.team1Scores,
        team2 = dbModel.team2,
        team2Image = dbModel.team2Image,
        team2Scores = dbModel.team2Scores,
        time = dbModel.time
    )
}