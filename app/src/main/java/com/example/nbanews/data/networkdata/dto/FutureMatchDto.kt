package com.example.nbanews.data.networkdata.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class FutureMatchDto(
    @SerializedName("team1")
    @Expose
    val team1: String? = null,

    @SerializedName("team1Scores")
    @Expose
    val team1Scores: String? = null,

    @SerializedName("team1Image")
    @Expose
    val team1Image: String? = null,

    @SerializedName("team2")
    @Expose
    val team2: String? = null,

    @SerializedName("team2Scores")
    @Expose
    val team2Scores: String? = null,

    @SerializedName("team2Image")
    @Expose
    val team2Image: String? = null,

    @SerializedName("time")
    @Expose
    val time: String? = null
)