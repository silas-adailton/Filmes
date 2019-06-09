package com.oliveira.silas.cad.ui.main

import android.app.Application
import com.oliveira.silas.cad.di.interactorModule
import com.oliveira.silas.cad.di.repositoryModule
import com.oliveira.silas.cad.di.retrofit
import com.oliveira.silas.cad.di.viewModelModule
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