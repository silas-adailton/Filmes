package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityMovieBinding
import org.koin.android.ext.android.inject
/**
*@author Silas
*/
class MovieActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMovieBinding
    private val viewModel: MovieViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        bind.viewModel = viewModel

        getMovies()
    }

    private fun getMovies() {
        viewModel.loadMovies(BuildConfig.API_KEY)
    }
}
