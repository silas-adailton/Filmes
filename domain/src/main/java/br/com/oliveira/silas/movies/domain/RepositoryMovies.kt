package br.com.oliveira.silas.movies.domain

import io.reactivex.Maybe

interface RepositoryMovies {
    fun getMovies(apiKey : String, page: Int) : Maybe<List<Movie>>
}