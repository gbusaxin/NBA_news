package com.example.nbanews.domain

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Keep
data class Comment(
    @SerializedName("author")
    @Expose
    val author: String,
    @SerializedName("comment")
    @Expose
    val comment: String
)