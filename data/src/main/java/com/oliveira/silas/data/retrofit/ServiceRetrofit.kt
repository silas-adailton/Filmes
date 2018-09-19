package com.oliveira.silas.data.retrofit

import com.oliveira.silas.data.remote.movie.MovieRemoteEntity
import com.oliveira.silas.data.remote.movie.MovieResponse
import com.oliveira.silas.domain.movies.Movie
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRetrofit {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String) : Maybe<MovieRemoteEntity>

    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String) : Maybe<MovieResponse>
}