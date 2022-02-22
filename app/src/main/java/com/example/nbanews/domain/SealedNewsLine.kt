package com.example.nbanews.domain

sealed class SealedNewsLine {

    data class NewsLineS(
        val date: String,
        val publications: List<PublicationS>
    ) : SealedNewsLine()

    data class PublicationS(
        val header: String,
        val tags: String,
        val body: String,
        val comments: List<Comment>
    ) : SealedNewsLine()

}
