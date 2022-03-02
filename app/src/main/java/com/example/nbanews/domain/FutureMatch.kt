package com.example.nbanews.domain

import androidx.annotation.Keep


@Keep
data class FutureMatch(
    val team1: String,
    val team1Scores: String,
    val team1Image: String,
    val team2: String,
    val team2Scores: String,
    val team2Image: String,
    val time: String
)