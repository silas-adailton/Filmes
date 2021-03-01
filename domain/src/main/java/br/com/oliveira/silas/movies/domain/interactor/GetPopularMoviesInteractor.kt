package br.com.oliveira.silas.movies.domain.interactor

import br.com.oliveira.silas.movies.domain.InteractorMaybe
import br.com.oliveira.silas.movies.domain.Movie
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.domain.Schedulers
import io.reactivex.Maybe

class GetPopularMoviesInteractor(
        schedulers: Schedulers,
        private val repositoryMovies: RepositoryMovies) :
        InteractorMaybe<List<Movie>, GetPopularMoviesInteractor.Request>(schedulers) {

    override fun create(request: Request): Maybe<List<Movie>> {
        return repositoryMovies.getMovies(request.getApiKey(), request.getPage())
    }


    inner class Request(private val api_key: String, private val page: Int) : InteractorMaybe.Request() {
        fun getApiKey(): String {
            return api_key
        }

        fun getPage() = page
    }
}