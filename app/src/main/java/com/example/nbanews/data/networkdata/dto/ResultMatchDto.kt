package com.example.nbanews.data.networkdata.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Keep
data class ResultMatchDto(
    @SerializedName("team1")
    @Expose
    val team1: String? = null,
    @SerializedName("team1Image")
    @Expose
    val team1Image: String? = null,
    @SerializedName("team1Score")
    @Expose
    val team1Score: String? = null,
    @SerializedName("team1Result")
    @Expose
    val team1Result: String? = null,
    @SerializedName("team2")
    @Expose
    val team2: String? = null,
    @SerializedName("team2Image")
    @Expose
    val team2Image: String? = null,
    @SerializedName("team2Score")
    @Expose
    val team2Score: String? = null,
    @SerializedName("team2Result")
    @Expose
    val team2Result: String? = null
)
