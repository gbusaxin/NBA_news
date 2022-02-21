package com.example.nbanews.data.networkdata.dto

import com.example.nbanews.domain.Publication

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NewsLineDto(
    @SerializedName("date")
    @Expose
    val date: String? = null,
    @SerializedName("publications")
    @Expose
    val publications: List<Publication>? = null
)