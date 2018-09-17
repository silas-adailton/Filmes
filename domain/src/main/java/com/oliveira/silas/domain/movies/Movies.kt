package com.oliveira.silas.domain.movies

data class Movies (
         val adult: Boolean,
         val backdrop_path: String,
         val id: Int,
         val original_title: String,
         val release_date: String,
         val poster_path: String,
         val popularity: String,
         val title: String,
         val video: Boolean,
         val vote_average: Float,
         val vote_count: Int
)