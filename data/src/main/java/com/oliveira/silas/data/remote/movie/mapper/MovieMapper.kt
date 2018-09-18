package com.oliveira.silas.data.remote.movie.mapper

import com.oliveira.silas.data.remote.movie.MovieResponse
import com.oliveira.silas.domain.movies.Movie

class MovieMapper {

    fun toModel(movieResponse: MovieResponse): List<Movie> {

        val listMovies: MutableList<Movie> = mutableListOf()

        for (res in movieResponse.results) {
            listMovies.add(Movie(
                    res.adult, res.backdrop_path,
                    res.id, res.original_title,
                    res.release_date, res.poster_path,
                    res.popularity, res.original_title!!,
                    res.video, res.vote_average, res.vote_count))
        }

        return listMovies
    }

}
