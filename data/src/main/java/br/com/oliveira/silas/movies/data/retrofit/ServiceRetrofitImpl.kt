package br.com.oliveira.silas.movies.data.retrofit

import br.com.oliveira.silas.movies.data.Constants
import br.com.oliveira.silas.movies.data.remote.movie.MovieRemoteEntity
import br.com.oliveira.silas.movies.data.remote.movie.MovieResponse
import io.reactivex.Maybe
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceRetrofitImpl(val apiKey: String) : ServiceRetrofit {
   private var serviceRetrofit: ServiceRetrofit

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

     serviceRetrofit = retrofit.create(ServiceRetrofit::class.java)
    }

    override fun getMovies(apiKey: String): Maybe<MovieRemoteEntity> {
        return serviceRetrofit.getMovies(this.apiKey)
    }

    override fun getMoviesPopular(apiKey: String): Maybe<MovieResponse> {
        return serviceRetrofit.getMoviesPopular(this.apiKey)
    }
}