package br.com.oliveira.silas.movies.ui.main

import android.app.Application
import br.com.oliveira.silas.movies.di.interactorModule
import br.com.oliveira.silas.movies.di.repositoryModule
import br.com.oliveira.silas.movies.di.retrofit
import br.com.oliveira.silas.movies.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(repositoryModule,
                    viewModelModule,
                    interactorModule,
                    retrofit)
        }

    }
}