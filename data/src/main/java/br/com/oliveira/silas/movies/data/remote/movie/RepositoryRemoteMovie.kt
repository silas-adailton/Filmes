package br.com.oliveira.silas.movies.data.remote.movie

import br.com.oliveira.silas.movies.data.remote.movie.mapper.MovieMapper
import br.com.oliveira.silas.movies.domain.Movie
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.data.retrofit.ServiceRetrofit
import br.com.oliveira.silas.movies.data.retrofit.ServiceRetrofitImpl
import io.reactivex.Maybe
import retrofit2.Retrofit

class RepositoryRemoteMovie(
        private val movieMapper: MovieMapper,
        val serviceRetrofitImpl: ServiceRetrofitImpl) : RepositoryMovies {
    override fun getMovies(apiKey: String, page: Int): Maybe<List<Movie>> {
        return serviceRetrofitImpl.getMoviesPopular(serviceRetrofitImpl.apiKey, page)
                .map { movieMapper.toModel(it) }
    }

}
