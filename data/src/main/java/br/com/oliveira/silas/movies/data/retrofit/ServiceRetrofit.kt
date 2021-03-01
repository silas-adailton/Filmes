package br.com.oliveira.silas.movies.data.retrofit

import br.com.oliveira.silas.movies.data.remote.movie.MovieRemoteEntity
import br.com.oliveira.silas.movies.data.remote.movie.MovieResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRetrofit {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String, @Query("page") page: Int) : Maybe<MovieRemoteEntity>

    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String, @Query("page") page: Int) : Maybe<MovieResponse>
}