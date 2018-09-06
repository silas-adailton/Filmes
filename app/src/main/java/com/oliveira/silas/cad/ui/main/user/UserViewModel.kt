package com.oliveira.silas.cad.ui.main.user

import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.data.Repository

class UserViewModel(private val repository: Repository): ViewModel(){

    fun sayHello() = repository.giveHello()

    fun getUser() = repository.getUsers()
}