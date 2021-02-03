package br.com.oliveira.silas.movies.data.remote.movie

import br.com.oliveira.silas.movies.data.remote.movie.mapper.MovieMapper
import br.com.oliveira.silas.movies.domain.Movie
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.data.retrofit.ServiceRetrofit
import io.reactivex.Maybe
import retrofit2.Retrofit

class RepositoryRemoteMovie(private val retrofit: Retrofit, private val movieMapper: MovieMapper) : RepositoryMovies {
    override fun getMovies(apiKey: String): Maybe<List<Movie>> {
        val serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)

        return serviceRetrofit.getMoviesPopular(apiKey)
                .map { movieMapper.toModel(it) }
    }


}