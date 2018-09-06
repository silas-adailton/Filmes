package com.oliveira.silas.cad.di

import com.google.firebase.database.FirebaseDatabase
import com.oliveira.silas.cad.data.Repository
import com.oliveira.silas.cad.data.RepositoryUser
import com.oliveira.silas.cad.domain.UserInteractor
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import org.koin.dsl.module.module

val myModule = module {

    single { RepositoryUser(get()) as Repository }
    factory { UserViewModel(get()) }
    factory { FirebaseDatabase.getInstance().getReference().child("user") }
    single { UserInteractor(get()) }
}

