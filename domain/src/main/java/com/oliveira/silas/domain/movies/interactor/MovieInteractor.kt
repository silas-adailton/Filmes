package com.oliveira.silas.domain.movies.interactor

import com.oliveira.silas.domain.InteractorMaybe
import com.oliveira.silas.domain.movies.Movies
import com.oliveira.silas.domain.movies.RepositoryMovies
import io.reactivex.Maybe

class MovieInteractor(val repositoryMovies: RepositoryMovies): InteractorMaybe<Movies, MovieInteractor.Request>() {

    override fun create(request: Request): Maybe<Movies> {
        return repositoryMovies.getMovies(request.getApiKey())
    }


    inner class Request(private var api_key: String) : InteractorMaybe.Request() {
        fun getApiKey(): String {
            return api_key
        }
    }
}