package com.oliveira.silas.cad.di

import com.oliveira.silas.cad.Constants
import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import com.oliveira.silas.data.remote.movie.RepositoryRemoteMoviePopular
import com.oliveira.silas.data.remote.movie.RepositoryRemoteMovieTopRate
import com.oliveira.silas.data.remote.movie.mapper.MovieMapper
import com.oliveira.silas.data.remote.user.RepositoryUser
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
import com.oliveira.silas.domain.movies.interactor.GetTopRateMoviesInteractor
import com.oliveira.silas.domain.user.Repository
import com.oliveira.silas.domain.user.interactor.UserInteractor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule: Module = module {
//    factory { FirebaseDatabase.getInstance().reference }

//    single<Repository> { RepositoryUser(get()) }
    single { MovieMapper() }
    single("popular"){ RepositoryRemoteMoviePopular(get(), get()) as RepositoryMovies }
    single("topRate") { RepositoryRemoteMovieTopRate(get(), get()) as RepositoryMovies }
}

val viewModelModule: Module = module {

    viewModel { UserViewModel(get()) }
    viewModel { MovieViewModel(get(), get()) }
}

val interactorModule: Module = module {
//    single { UserInteractor(get()) }
    single { GetPopularMoviesInteractor(get("popular")) }
    single { GetTopRateMoviesInteractor(get("topRate")) }

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

