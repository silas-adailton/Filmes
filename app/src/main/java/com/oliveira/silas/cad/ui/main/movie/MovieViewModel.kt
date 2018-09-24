package com.oliveira.silas.cad.ui.main.movie

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver

class MovieViewModel(val getPopularMoviesInteractor: GetPopularMoviesInteractor) : ViewModel() {
    private val disposable = CompositeDisposable()

    val loading = ObservableBoolean()
    var result: MutableList<Movie> = ObservableArrayList<Movie>()
    val error = ObservableField<String>()
    val empty = ObservableBoolean()


    fun loadMovies(apiKey: String) = disposable.add(getUser(apiKey))

    private fun getUser(apiKey: String): Disposable {
        return getPopularMoviesInteractor.execute(getPopularMoviesInteractor.Request(apiKey))
                .subscribeWith(object : DisposableMaybeObserver<List<Movie>>() {

                    override fun onStart() {
                        loading.set(true)
                    }

                    override fun onSuccess(movie: List<Movie>) {
                        loading.set(false)
                        result.clear()
                        result.addAll(movie)
//                        Log.d("TESTE", "" + movie)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        loading.set(false)

//                        Log.d("TESTE", e.message)
                    }

                })
    }

    override fun onCleared() {
        disposable.dispose()
    }


}