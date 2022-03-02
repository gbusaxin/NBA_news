package com.example.nbanews.domain

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class Total(
    @SerializedName("season")
    @Expose
    val season: String,
    @SerializedName("g")
    @Expose
    val g: String,
    @SerializedName("fg")
    @Expose
    val fg: String,
    @SerializedName("off")
    @Expose
    val off: String,
    @SerializedName("rpg")
    @Expose
    val rpg: String
)