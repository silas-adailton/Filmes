package com.oliveira.silas.cad.di

import com.oliveira.silas.cad.Constants
import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.data.remote.movie.RepositoryRemoteMovie
import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
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

