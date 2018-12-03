package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityMovieBinding
import com.oliveira.silas.cad.internal.binding.bindAdapters
import org.koin.android.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity(), bindAdapters.Testsss {

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

    override fun loadMore(){
//        viewModel.loadPopularMovies(BuildConfig.API_KEY)
//        Toast.makeText(this, "Chamou na Activity", Toast.LENGTH_SHORT).show()

        Log.d("TESTE","Chamou na Activity")

    }




}
