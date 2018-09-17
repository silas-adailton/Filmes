package com.oliveira.silas.cad.di

import com.google.firebase.database.FirebaseDatabase
import com.oliveira.silas.cad.data.Repository
import com.oliveira.silas.cad.data.RepositoryUser
import com.oliveira.silas.cad.domain.UserInteractor
import com.oliveira.silas.cad.ui.main.user.LoginViewModel
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val repositoryModule: Module = module {
    factory { FirebaseDatabase.getInstance().reference }

    single<Repository> { RepositoryUser(get()) }
}

val viewModelModule: Module = module {

    viewModel { UserViewModel(get()) }
    viewModel { LoginViewModel() }
}

val interactorModule: Module = module {
    single { UserInteractor(get()) }

}

