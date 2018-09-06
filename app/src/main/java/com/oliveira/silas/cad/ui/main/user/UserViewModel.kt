package com.oliveira.silas.cad.ui.main.user

import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.domain.UserInteractor

class UserViewModel(val userInteractor: UserInteractor): ViewModel(){

//    fun sayHello() = repository.giveHello()

    fun getUser() = userInteractor.getUserInteractor()
}