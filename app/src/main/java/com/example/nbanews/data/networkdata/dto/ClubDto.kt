package com.example.nbanews.data.networkdata.dto

import androidx.annotation.Keep
import com.example.nbanews.domain.Composition
import com.example.nbanews.domain.Total

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class ClubDto(
    @SerializedName("club")
    @Expose
    val club: String? = null,
    @SerializedName("clubImage")
    @Expose
    val clubImage: String? = null,
    @SerializedName("wins")
    @Expose
    val wins: String? = null,
    @SerializedName("fails")
    @Expose
    val fails: String? = null,
    @SerializedName("percent")
    @Expose
    val percent: String? = null,
    @SerializedName("pos")
    @Expose
    val pos: String? = null,
    @SerializedName("composition")
    @Expose
    val composition: List<Composition>? = null,
    @SerializedName("totals")
    @Expose
    val totals: List<Total>? = null
)