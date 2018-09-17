package com.oliveira.silas.domain.user

import com.oliveira.silas.domain.user.User
import io.reactivex.Maybe

interface Repository {
    fun saveUser() : Maybe<User>
    fun getUsers() : Maybe<List<User>>
    fun getUserCourotine(): MutableList<User>
}