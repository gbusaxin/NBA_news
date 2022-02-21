package com.example.nbanews.data.database.converters

import androidx.room.TypeConverter
import com.example.nbanews.domain.Publication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class NewsLineConverter {
    @TypeConverter
    fun toListPublicationsFromJson(publication: String): List<Publication> {
        val type: Type = object : TypeToken<List<Publication>>() {}.type
        return Gson().fromJson(publication, type)
    }

    @TypeConverter
    fun fromJsonToListTeams(publications: List<Publication>): String {
        return Gson().toJson(publications)
    }
}