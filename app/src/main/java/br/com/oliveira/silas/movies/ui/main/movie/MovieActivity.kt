package br.com.oliveira.silas.movies.ui.main.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.oliveira.silas.movies.BuildConfig
import br.com.oliveira.silas.movies.R
import br.com.oliveira.silas.movies.databinding.ActivityMovieBinding
import org.koin.android.ext.android.inject

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
