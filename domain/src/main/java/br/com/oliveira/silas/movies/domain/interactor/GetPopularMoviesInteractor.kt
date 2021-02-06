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
        return repositoryMovies.getMovies(request.getApiKey())
    }


    inner class Request(private var api_key: String) : InteractorMaybe.Request() {
        fun getApiKey(): String {
            return api_key
        }
    }
}