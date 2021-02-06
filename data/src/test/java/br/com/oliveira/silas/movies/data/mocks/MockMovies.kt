package br.com.oliveira.silas.movies.data.mocks

import br.com.oliveira.silas.movies.domain.Movie

class MockMovies {
    companion object {
        private fun getMovie() = Movie(true, null, 1, "Teste",
                "21/09/2018", "tasrddtsa",
                2F, "uydasd", false, 5F, 5)

        fun getListMovies() = listOf(getMovie())
    }
}