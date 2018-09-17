package com.oliveira.silas.domain.movies

import io.reactivex.Maybe

interface RepositoryMovies {
    fun getMovies(apiKey : String) : Maybe<Movies>
}