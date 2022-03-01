package com.example.nbanews.data.mappers

import com.example.nbanews.data.database.model.ClubEntity
import com.example.nbanews.data.networkdata.dto.ClubDto
import com.example.nbanews.domain.Club
import com.example.nbanews.util.PatternMapper
import java.util.*
import javax.inject.Inject

class ClubMapper @Inject constructor() : PatternMapper<Club, ClubDto, ClubEntity> {

    override fun mapDtoToDbModel(dto: ClubDto) = ClubEntity(
        club = dto.club ?: "",
        clubImage = dto.clubImage ?: "",
        wins = dto.wins ?: "",
        fails = dto.fails ?: "",
        percent = dto.percent ?: "",
        pos = dto.pos ?: "",
        composition = dto.composition ?: Collections.emptyList(),
        totals = dto.totals ?: Collections.emptyList()
    )

    override fun mapDbModelToEntity(dbModel: ClubEntity) = Club(
        club = dbModel.club,
        clubImage = dbModel.clubImage,
        wins = dbModel.wins,
        fails = dbModel.fails,
        percent = dbModel.percent,
        pos = dbModel.pos,
        composition = dbModel.composition,
        totals = dbModel.totals
    )

}