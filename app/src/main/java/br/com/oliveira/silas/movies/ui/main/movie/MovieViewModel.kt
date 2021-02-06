package br.com.oliveira.silas.movies.ui.main.movie

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import br.com.oliveira.silas.movies.domain.Movie
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver

class MovieViewModel(private val getPopularMoviesInteractor: GetPopularMoviesInteractor) : ViewModel() {
    private val disposable = CompositeDisposable()

    val loading = ObservableBoolean()
    var result: MutableList<Movie> = ObservableArrayList()
    val error = ObservableField<String>()
    val empty = ObservableBoolean()


    fun loadMovies(apiKey: String) = disposable.add(getMovies(apiKey))

    private fun getMovies(apiKey: String): Disposable {
        return getPopularMoviesInteractor.execute(getPopularMoviesInteractor.Request(apiKey))
                .subscribeWith(object : DisposableMaybeObserver<List<Movie>>() {

                    override fun onStart() {
                        loading.set(true)
                    }

                    override fun onSuccess(movie: List<Movie>) {
                        loading.set(false)
                        result.clear()
                        result.addAll(movie)
                        Log.d("TESTE", "" + movie)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        loading.set(false)
                        error.set(e.toString())

                        Log.d("TESTE", e.message)
                    }

                })
    }

    override fun onCleared() {
        disposable.dispose()
    }


}