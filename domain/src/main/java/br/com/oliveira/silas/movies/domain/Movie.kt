package br.com.oliveira.silas.movies.domain

data class Movie (
        var adult: Boolean,
        val backdropPath: String?,
        val id: Int,
        val originalTitle: String?,
        val releaseDate: String,
        val posterPath: String?,
        val popularity: Float?,
        val title: String,
        val video: Boolean,
        val voteAverage: Float,
        val voteCount: Int
)