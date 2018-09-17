package com.oliveira.silas.data.remote.movie

import android.util.Log
import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.domain.movies.Movies
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.domain.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import io.reactivex.observers.DisposableMaybeObserver
import retrofit2.Retrofit

class RepositoryRemoteMovie(val retrofit: Retrofit, val movieMapper: MovieMapper) : RepositoryMovies {
    override fun getMovies(api_key: String): Maybe<Movies> {

        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getMovies(api_key).map { movieMapper.toModel(it) }

    }
}