package com.oliveira.silas.cad.ui.main.movie

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
import com.oliveira.silas.domain.movies.interactor.GetTopRateMoviesInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver

class MovieViewModel(private val getPopularMoviesInteractor: GetPopularMoviesInteractor, private val getTopRateMoviesInteractor: GetTopRateMoviesInteractor) : ViewModel() {
    private val disposable = CompositeDisposable()

    val loading = ObservableBoolean()
    var result: MutableList<Movie> = ObservableArrayList<Movie>()
    var resultData: MutableLiveData<List<Movie>> = MutableLiveData()
    val error = ObservableField<Throwable>()
    val empty = ObservableBoolean()
    val res = resultData


    fun loadPopularMovies(apiKey: String) = disposable.add(getPopularMovies(apiKey))
    fun loadTopRateMovies(apiKey: String) = disposable.add(getTopRateMovies(apiKey))

    private fun getPopularMovies(apiKey: String): Disposable {
        return getPopularMoviesInteractor.execute(getPopularMoviesInteractor.Request(apiKey))
                .subscribeWith(object : DisposableMaybeObserver<List<Movie>>() {

                    override fun onStart() {
                        loading.set(true)
                    }

                    override fun onSuccess(movie: List<Movie>) {
                        loading.set(false)
                        result.clear()
                        result.addAll(movie)
                        resultData.value = movie
                        Log.d("TESTE", "" + movie)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        loading.set(false)

                        Log.d("TESTE", e.message)
                    }

                })
    }

    private fun getTopRateMovies(apiKey: String): Disposable {
        return getTopRateMoviesInteractor.execute(getTopRateMoviesInteractor.Request(apiKey))
                .subscribeWith(object : DisposableMaybeObserver<List<Movie>>() {

                    override fun onStart() {
                        loading.set(true)
                    }

                    override fun onSuccess(movie: List<Movie>) {
                        loading.set(false)
                        result.clear()
                        result.addAll(movie)
                        resultData.value = movie
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        loading.set(false)
                        error.set(e)
                    }

                })
    }

    override fun onCleared() {
        disposable.dispose()
    }


}