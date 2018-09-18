package com.oliveira.silas.cad.ui.main.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver

class MovieViewModel(val getPopularMoviesInteractor: GetPopularMoviesInteractor) : ViewModel() {
    private val disposable = CompositeDisposable()


    fun loadMovies(apiKey: String) = disposable.add(getUser(apiKey))

    private fun getUser(apiKey: String): Disposable {
        return getPopularMoviesInteractor.execute(getPopularMoviesInteractor.Request(apiKey))
                .subscribeWith(object : DisposableMaybeObserver<List<Movie>>() {
                    override fun onSuccess(movie: List<Movie>) {
                        Log.d("TESTE", "" + movie)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {

                        Log.d("TESTE", e.message)
                    }

                })
    }

    override fun onCleared() {
        disposable.dispose()
    }


}