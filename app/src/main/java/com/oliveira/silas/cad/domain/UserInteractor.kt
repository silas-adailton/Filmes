package com.oliveira.silas.cad.domain

import com.oliveira.silas.cad.data.Repository
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserInteractor (private val repository: Repository){

     fun getUserInteractor(): Maybe<List<User>> {

         return repository.getUsers()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
     }

    fun getUserssssss(): MutableList<User> {

        return repository.getUserCourotine()
    }
}