package com.oliveira.silas.data.remote.movie

import com.oliveira.silas.domain.movies.Movies
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.domain.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import retrofit2.Retrofit

class RepositoryRemoteMovie(val retrofit: Retrofit) : RepositoryMovies {
    override fun getMovies(api_key : String): Maybe<Movies> {

        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getMovies(api_key)

    }
}