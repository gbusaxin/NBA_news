package com.example.nbanews.domain

import androidx.annotation.Keep

@Keep
data class ResultMatch(
    val team1: String,
    val team1Image: String,
    val team1Score: String,
    val team1Result: String,
    val team2: String,
    val team2Image: String,
    val team2Score: String,
    val team2Result: String
)