package com.example.nbanews.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Comment(
    @SerializedName("author")
    @Expose
    val author: String,
    @SerializedName("comment")
    @Expose
    val comment: String
)