package com.oliveira.silas.cad.di

import com.google.firebase.database.FirebaseDatabase
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import com.oliveira.silas.data.remote.user.RepositoryUser
import com.oliveira.silas.domain.user.Repository
import com.oliveira.silas.domain.user.interactor.UserInteractor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val repositoryModule: Module = module {
    factory { FirebaseDatabase.getInstance().reference }

    single<Repository> { RepositoryUser(get()) }
}

val viewModelModule: Module = module {

    viewModel { UserViewModel(get()) }
}

val interactorModule: Module = module {
    single { UserInteractor(get()) }

}

