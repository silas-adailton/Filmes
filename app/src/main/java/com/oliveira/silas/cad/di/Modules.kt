package com.oliveira.silas.cad.di

import com.google.firebase.database.FirebaseDatabase
import com.oliveira.silas.cad.data.Repository
import com.oliveira.silas.cad.data.RepositoryUser
import com.oliveira.silas.cad.domain.UserInteractor
import com.oliveira.silas.cad.ui.main.user.LoginViewModel
import com.google.gson.Gson
import com.oliveira.silas.cad.Constants
import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import com.oliveira.silas.data.remote.movie.RepositoryRemoteMovie
import com.oliveira.silas.data.remote.user.RepositoryUser
import com.oliveira.silas.domain.movies.RepositoryMovies
import com.oliveira.silas.domain.movies.interactor.MovieInteractor
import com.oliveira.silas.domain.user.Repository
import com.oliveira.silas.domain.user.interactor.UserInteractor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule: Module = module {
    factory { FirebaseDatabase.getInstance().reference }

    single<Repository> { RepositoryUser(get()) }
    single<RepositoryMovies> { RepositoryRemoteMovie(get()) }
}

val viewModelModule: Module = module {

    viewModel { UserViewModel(get()) }
    viewModel { LoginViewModel() }
    viewModel { MovieViewModel(get()) }
}

val interactorModule: Module = module {
    single { UserInteractor(get()) }
    single { MovieInteractor(get()) }

}

val retrofit = module {
    val BASE_URL = "http://api.themoviedb.org/3/"
    factory {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}

