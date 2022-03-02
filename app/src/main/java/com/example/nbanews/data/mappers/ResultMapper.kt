package com.example.nbanews.data.mappers

import com.example.nbanews.data.database.model.ResultMatchEntity
import com.example.nbanews.data.networkdata.dto.ResultMatchDto
import com.example.nbanews.domain.ResultMatch
import com.example.nbanews.util.PatternMapper
import javax.inject.Inject

class ResultMapper @Inject constructor() : PatternMapper<ResultMatch,ResultMatchDto,ResultMatchEntity> {
    override fun mapDtoToDbModel(dto: ResultMatchDto) = ResultMatchEntity(
        id = 0,
        team1 = dto.team1?:"",
        team1Image = dto.team1Image?:"",
        team1Score = dto.team1Score?:"",
        team1Result = dto.team1Result?:"",
        team2 = dto.team2?:"",
        team2Image = dto.team2Image?:"",
        team2Score = dto.team2Score?:"",
        team2Result = dto.team2Result?:""
    )

    override fun mapDbModelToEntity(dbModel: ResultMatchEntity) = ResultMatch(
        team1 = dbModel.team1,
        team1Image = dbModel.team1Image,
        team1Score = dbModel.team1Score,
        team1Result = dbModel.team1Result,
        team2 = dbModel.team2,
        team2Image = dbModel.team2Image,
        team2Score = dbModel.team2Score,
        team2Result = dbModel.team2Result
    )
}