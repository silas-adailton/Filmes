package com.oliveira.silas.data.remote.movie

class MovieEntity(
        private val adult: Boolean,
        private val backdrop_path: String,
        private val id: Int,
        private val original_title: String,
        private val release_date: String,
        private val poster_path: String,
        private val popularity: String,
        private val title: String,
        private val video: Boolean,
        private val vote_average: Float,
        private val vote_count: Int
)