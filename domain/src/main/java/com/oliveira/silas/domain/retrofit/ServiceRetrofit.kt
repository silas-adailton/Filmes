package com.oliveira.silas.domain.retrofit

import com.oliveira.silas.domain.movies.Movies
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRetrofit {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String) : Maybe<Movies>
}