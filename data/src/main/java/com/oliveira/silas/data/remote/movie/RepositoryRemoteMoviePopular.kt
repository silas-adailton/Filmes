package com.oliveira.silas.data.remote.movie

import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.data.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.Retrofit

class RepositoryRemoteMoviePopular(private val retrofit: Retrofit, private val movieMapper: MovieMapper) : RepositoryMovies {

    override fun getMovies(apiKey: String): Maybe<List<Movie>> {
        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getMoviesPopular(apiKey)
                .flatMapObservable {t ->  Observable.fromIterable(t.results) }
                .map{res ->  Movie(
                        res.adult, res.backdrop_path,
                        res.id, res.original_title,
                        res.release_date, res.poster_path,
                        res.popularity, res.original_title!!,
                        res.video, res.vote_average, res.vote_count)}
                .toList()
                .toMaybe()

    }


}