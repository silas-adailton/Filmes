package br.com.oliveira.silas.movies.data.mocks

import br.com.oliveira.silas.movies.data.remote.movie.MovieRemoteEntity
import br.com.oliveira.silas.movies.data.remote.movie.MovieResponse
import br.com.oliveira.silas.movies.domain.Movie

class MockMovies {
    companion object {
        fun getMovieEntityRemote() = MovieRemoteEntity(true, null, 1,
                "Teste",
                "21/09/2018", "tasrddtsa",
                2F, "uydasd", false, 5F, 5
        )
    }
}