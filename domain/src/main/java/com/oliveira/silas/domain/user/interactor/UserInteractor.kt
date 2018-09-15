package com.oliveira.silas.domain.user.interactor

import com.oliveira.silas.domain.InteractorMaybe
import com.oliveira.silas.domain.user.Repository
import com.oliveira.silas.domain.user.User
import io.reactivex.Maybe

class UserInteractor (private val repository: Repository): InteractorMaybe<List<User>, UserInteractor.Request>() {

    override fun create(request: Request): Maybe<List<User>> {
       return repository.getUsers()
    }

    fun getUserssssss(): MutableList<User> {

        return repository.getUserCourotine()
    }

    inner class Request : InteractorMaybe.Request() {

    }
}