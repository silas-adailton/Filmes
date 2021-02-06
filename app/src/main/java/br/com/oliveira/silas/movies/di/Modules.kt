package br.com.oliveira.silas.movies.di

import br.com.oliveira.silas.movies.BuildConfig
import br.com.oliveira.silas.movies.ui.main.movie.MovieViewModel
import br.com.oliveira.silas.movies.data.remote.movie.RepositoryRemoteMovie
import br.com.oliveira.silas.movies.data.remote.movie.mapper.MovieMapper
import br.com.oliveira.silas.movies.data.retrofit.ServiceRetrofit
import br.com.oliveira.silas.movies.data.retrofit.ServiceRetrofitImpl
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.domain.Schedulers
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import br.com.oliveira.silas.movies.util.scheduler.AppScheduler
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single { MovieMapper() }
    single<RepositoryMovies> { RepositoryRemoteMovie(get(), get()) }
}

val viewModelModule: Module = module {
    viewModel { MovieViewModel(get()) }
}


val interactorModule: Module = module {
    single<Schedulers> { AppScheduler() }
    single { GetPopularMoviesInteractor(get(), get()) }

}

val retrofit = module {
//    factory {
//        Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//    }

//    factory<ServiceRetrofit> { ServiceRetrofitImpl(BuildConfig.API_KEY) }
    single<ServiceRetrofit> { ServiceRetrofitImpl() }
}

