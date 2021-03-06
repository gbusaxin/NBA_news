package com.example.nbanews.domain

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Publication(
    @SerializedName("header")
    @Expose
    val header: String,
    @SerializedName("tags")
    @Expose
    val tags: String,
    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("comments")
    @Expose
    val comments: List<Comment>
)