package com.oliveira.silas.domain.movies.interactor

import android.util.Log
import com.oliveira.silas.domain.InteractorMaybe
import com.oliveira.silas.domain.Preferences
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.RepositoryMovies
import io.reactivex.Maybe

class GetPopularMoviesInteractor(val repositoryMovies: RepositoryMovies, val preferences: Preferences): InteractorMaybe<List<Movie>, GetPopularMoviesInteractor.Request>() {

    override fun create(request: Request): Maybe<List<Movie>> {
        return repositoryMovies.getInfoPages(request.getApiKey())
                .map { numberPages -> {
                    preferences.saveNumberPages(numberPages.totalPages)

                    Log.d("NUMBER_PAGES",numberPages.totalPages.toString())
                } }
                .flatMap{repositoryMovies.getMovies(request.getApiKey())}

    }


     inner class Request(private var api_key: String) : InteractorMaybe.Request() {
        fun getApiKey(): String {
            return api_key
        }
    }
}