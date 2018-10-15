package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMovieBinding
    private val viewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        bind.viewModel = viewModel

        getMovies()
    }

    private fun getMovies() {
        viewModel.loadPopularMovies(BuildConfig.API_KEY)
    }
}
