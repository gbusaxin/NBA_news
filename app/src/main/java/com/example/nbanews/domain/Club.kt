package com.example.nbanews.domain


data class Club(
    val club: String,
    val clubImage: String,
    val wins: String,
    val fails: String,
    val percent: String,
    val pos: String,
    val composition: List<Composition>,
    val totals: List<Total>
)