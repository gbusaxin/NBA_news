package com.example.nbanews.data.mappers

import com.example.nbanews.data.database.model.NewsLineEntity
import com.example.nbanews.data.networkdata.dto.NewsLineDto
import com.example.nbanews.domain.NewsLine
import com.example.nbanews.util.PatternMapper
import java.util.*
import javax.inject.Inject

class NewsLineMapper @Inject constructor(): PatternMapper<NewsLine, NewsLineDto, NewsLineEntity> {
    override fun mapDtoToDbModel(dto: NewsLineDto): NewsLineEntity {
        return NewsLineEntity(
            date = dto.date ?: "",
            publications = dto.publications ?: Collections.emptyList()
        )
    }

    override fun mapDbModelToEntity(dbModel: NewsLineEntity): NewsLine {
        return NewsLine(
            date = dbModel.date,
            publications = dbModel.publications
        )
    }
}