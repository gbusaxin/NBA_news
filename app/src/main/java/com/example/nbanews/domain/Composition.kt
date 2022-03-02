package com.example.nbanews.domain

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Keep
data class Composition(
    @SerializedName("playerName")
    @Expose
    val playerName: String,
    @SerializedName("playerImage")
    @Expose
    val playerImage: String,
    @SerializedName("playerNumber")
    @Expose
    val playerNumber: String,
    @SerializedName("playerCountry")
    @Expose
    val playerCountry: String
)