package com.oliveira.silas.domain

import io.reactivex.Completable

interface Preferences {
    fun getNumberPages(): Int
    fun saveNumberPages(numberPages : Int): Completable
}