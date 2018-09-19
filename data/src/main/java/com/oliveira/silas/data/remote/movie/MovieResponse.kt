package com.oliveira.silas.data.remote.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse (
        val page: Int,
        val results: List<MovieRemoteEntity>,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int
)