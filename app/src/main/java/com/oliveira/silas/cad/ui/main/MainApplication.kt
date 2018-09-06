package com.oliveira.silas.cad.ui.main

import android.app.Application
import com.oliveira.silas.cad.di.interactorModule
import com.oliveira.silas.cad.di.repositoryModule
import com.oliveira.silas.cad.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this,
                listOf(repositoryModule,
                        viewModelModule,
                        interactorModule))

    }
}