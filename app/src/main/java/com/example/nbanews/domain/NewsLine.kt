package com.example.nbanews.domain

import androidx.annotation.Keep


@Keep
data class NewsLine(
    val date: String,
    val publications: List<Publication>
)