package com.oliveira.silas.data.retrofit

import com.oliveira.silas.data.remote.movie.MovieResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRetrofit {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String) : Maybe<MovieResponse>

    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String) : Maybe<MovieResponse>
}