package br.com.oliveira.silas.domain.util

import br.com.oliveira.silas.movies.domain.Schedulers
import io.reactivex.Scheduler

class TestScheduler : Schedulers {
    override val subscribeOn: Scheduler
        get() = io.reactivex.schedulers.Schedulers.trampoline()
    override val observeOn: Scheduler
        get() = io.reactivex.schedulers.Schedulers.trampoline()
}