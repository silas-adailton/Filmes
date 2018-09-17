package com.oliveira.silas.cad.ui.main.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import com.oliveira.silas.domain.movies.Movies
import com.oliveira.silas.domain.movies.interactor.MovieInteractor
import io.reactivex.observers.DisposableMaybeObserver

class MovieViewModel(val movieInteractor: MovieInteractor): ViewModel() {
    fun getMovies(apiKey: String) {

        return movieInteractor.execute(movieInteractor.Request(apiKey)).subscribe(object : DisposableMaybeObserver<Movies>(){
            override fun onSuccess(movies: Movies) {
                Log.d("TESTE", ""+movies)
            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {

                Log.d("TESTE",e.message)
            }

        })
    }
}