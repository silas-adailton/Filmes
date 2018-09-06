package com.oliveira.silas.cad.data

import com.oliveira.silas.cad.domain.User
import io.reactivex.Maybe

interface Repository {
    fun saveUser() : Maybe<User>
    fun getUsers() : Maybe<List<User>>
    fun giveHello(): String
}