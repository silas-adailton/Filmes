package com.oliveira.silas.cad.ui.main.user

import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.domain.UserInteractor
import io.reactivex.Maybe

class UserViewModel(val userInteractor: UserInteractor): ViewModel(){

//    fun getUser() = userInteractor.getUserInteractor()

    fun getUser(): Maybe<List<User>> {
        return userInteractor.getUserInteractor()
    }
}