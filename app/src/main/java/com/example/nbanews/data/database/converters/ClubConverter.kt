package com.example.nbanews.data.database.converters

import androidx.room.TypeConverter
import com.example.nbanews.domain.Composition
import com.example.nbanews.domain.Publication
import com.example.nbanews.domain.Total
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ClubConverter {
    @TypeConverter
    fun toListCompositionsFromJson(compositions: String): List<Composition> {
        val type: Type = object : TypeToken<List<Composition>>() {}.type
        return Gson().fromJson(compositions, type)
    }

    @TypeConverter
    fun fromJsonToListCompositions(compositions: List<Composition>): String {
        return Gson().toJson(compositions)
    }

    @TypeConverter
    fun toListTotalsFromJson(totals: String): List<Total> {
        val type: Type = object : TypeToken<List<Total>>() {}.type
        return Gson().fromJson(totals, type)
    }

    @TypeConverter
    fun fromJsonToListTotals(totals: List<Total>): String {
        return Gson().toJson(totals)
    }
}