package com.oliveira.silas.data.remote.movie

import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.data.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import io.reactivex.observers.DisposableMaybeObserver
import retrofit2.Retrofit

class RepositoryRemoteMovie(private val retrofit: Retrofit, private val movieMapper: MovieMapper) : RepositoryMovies {
    override fun getMovies(apiKey: String): Maybe<List<Movie>> {
        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getMoviesPopular(apiKey)
                .map { movieMapper.toModel(it) }
    }


}