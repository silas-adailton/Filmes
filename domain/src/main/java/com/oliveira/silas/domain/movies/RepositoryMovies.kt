package com.oliveira.silas.domain.movies

import io.reactivex.Maybe

interface RepositoryMovies {
    fun getMovies(apiKey : String) : Maybe<List<Movie>>
    fun getInfoPages(apiKey : String) : Maybe<Movie>
}