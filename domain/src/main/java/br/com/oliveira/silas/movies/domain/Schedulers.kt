package br.com.oliveira.silas.movies.domain

import io.reactivex.Scheduler

interface Schedulers {
    val subscribeOn: Scheduler
    val observeOn: Scheduler
}
