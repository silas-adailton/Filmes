package com.oliveira.silas.data.remote.movie

import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.data.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import retrofit2.Retrofit

class RepositoryRemoteMovieTopRate(private val retrofit: Retrofit, private val movieMapper: MovieMapper) : RepositoryMovies {

    override fun getMovies(apiKey: String): Maybe<List<Movie>> {
        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getTopRatedMovies(apiKey)
                .map { movieMapper.toListModel(it) }
    }


}