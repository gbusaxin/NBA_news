package com.example.nbanews.util

interface PatternMapper<Entity, Network, Database> {

    fun mapDtoToDbModel(dto: Network): Database

    fun mapDbModelToEntity(dbModel: Database): Entity

}