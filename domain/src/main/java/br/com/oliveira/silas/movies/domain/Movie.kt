package br.com.oliveira.silas.movies.domain

data class Movie (
        val id: Int,
        val page: Int,
        val adult: Boolean,
        val backdropPath: String?,
        val originalTitle: String?,
        val releaseDate: String,
        val posterPath: String?,
        val popularity: Float?,
        val title: String,
        val video: Boolean,
        val voteAverage: Float,
        val voteCount: Int
)