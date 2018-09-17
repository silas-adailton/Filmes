package com.oliveira.silas.data.remote.movie.mapper

import com.oliveira.silas.data.remote.movie.MovieEntity
import com.oliveira.silas.domain.movies.Movies

class MovieMapper {

    fun toModel(movieEntity: MovieEntity) =
            Movies(
            movieEntity.adult, movieEntity.backdrop_path, movieEntity.id,
            movieEntity.original_title, movieEntity.release_date, movieEntity.poster_path,
            movieEntity.popularity, movieEntity.title, movieEntity.video,
            movieEntity.vote_count.toFloat(), movieEntity.vote_average.toInt())

}