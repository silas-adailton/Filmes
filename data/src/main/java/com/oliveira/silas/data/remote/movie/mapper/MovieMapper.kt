package com.oliveira.silas.data.remote.movie.mapper

import com.oliveira.silas.data.remote.movie.MovieResponse
import com.oliveira.silas.domain.movies.Movie

class MovieMapper {

    fun toListModel(movieResponse: MovieResponse): List<Movie> {

        val listMovies: MutableList<Movie> = mutableListOf()

        for (res in movieResponse.results) {
            listMovies.add(Movie(
                    res.adult,
                    res.backdrop_path,
                    res.id,
                    res.original_title,
                    res.release_date,
                    res.overview,
                    res.poster_path,
                    res.popularity,
                    res.original_title!!,
                    res.video,
                    res.vote_average,
                    res.vote_count))
        }

        return listMovies
    }

    fun toModel(movieResponse: MovieResponse):Movie? {
        val movie: Movie? = null
        movie?.page = movieResponse.page
        movie?.totalPages = movieResponse.totalPages
        movie?.totalResults = movieResponse.totalResults

        return movie
    }


}
