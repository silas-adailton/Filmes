package br.com.oliveira.silas.movies.util.scheduler

import br.com.oliveira.silas.movies.domain.Schedulers
import io.reactivex.Scheduler

class AppScheduler : Schedulers {
    override val subscribeOn: Scheduler
        get() = io.reactivex.schedulers.Schedulers.io()
    override val observeOn: Scheduler
        get() = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
}
