package br.com.oliveira.silas.movies.di

import br.com.oliveira.silas.movies.Constants
import br.com.oliveira.silas.movies.ui.main.movie.MovieViewModel
import br.com.oliveira.silas.movies.data.remote.movie.RepositoryRemoteMovie
import br.com.oliveira.silas.movies.data.remote.movie.mapper.MovieMapper
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule: Module = module {
    single { MovieMapper() }
    single<RepositoryMovies> { RepositoryRemoteMovie(get(), get()) }
}

val viewModelModule: Module = module {
    viewModel { MovieViewModel(get()) }
}


val interactorModule: Module = module {
    single { GetPopularMoviesInteractor(get()) }

}

val retrofit = module {
    factory {
        Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}

