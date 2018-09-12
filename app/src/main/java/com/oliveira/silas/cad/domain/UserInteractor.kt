package com.oliveira.silas.cad.domain

import com.oliveira.silas.cad.data.Repository
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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