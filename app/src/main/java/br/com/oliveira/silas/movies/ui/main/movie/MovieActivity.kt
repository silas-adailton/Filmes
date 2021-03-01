package br.com.oliveira.silas.movies.ui.main.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.oliveira.silas.movies.BuildConfig
import br.com.oliveira.silas.movies.R
import br.com.oliveira.silas.movies.databinding.ActivityMovieBinding
import br.com.oliveira.silas.movies.domain.Movie
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject
import java.util.ArrayList

class MovieActivity : AppCompatActivity() {
    var page = 1

    private var listMovies: MutableList<Movie> = mutableListOf()
    private lateinit var bind: ActivityMovieBinding
    private lateinit var listMovieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        bind.viewModel = viewModel

        getMovies(page)
        setupRecyclerView()
        observeListMovies()

    }

    private fun getMovies(page: Int) {
        viewModel.loadMovies(BuildConfig.API_KEY, page)
    }

    private fun observeListMovies() {

        viewModel.resultLiveData.observe(this, Observer {
            it.forEach { movie -> listMovies.add(movie) }
            listMovieAdapter.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        recyclerview_movie.layoutManager = layoutManager

        listMovieAdapter = MovieAdapter(listMovies)

        recyclerview_movie.adapter = listMovieAdapter

        recyclerview_movie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = listMovieAdapter.itemCount

                if (!viewModel.loading.get()) {
                    if ((visibleItemCount + pastVisibleItem) >= total - 5) {
                        page++
                        viewModel.loadMovies(BuildConfig.API_KEY, page)
                    }
                }

            }
        })
    }
}
