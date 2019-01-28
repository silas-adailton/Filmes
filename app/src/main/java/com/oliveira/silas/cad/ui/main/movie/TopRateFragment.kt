package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityMovieBinding
import com.oliveira.silas.cad.databinding.FragmentTopRateBinding
import com.oliveira.silas.cad.ui.main.movie.adapter.MovieAdapter
import com.oliveira.silas.domain.movies.Movie
import org.koin.android.viewmodel.ext.android.viewModel

class TopRateFragment : Fragment() {

    private lateinit var binding: FragmentTopRateBinding
    private val viewModel: MovieViewModel by viewModel()

    companion object {

        @JvmStatic
        fun newInstance(): TopRateFragment {
            val fragment = TopRateFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rate, container, false)
        binding.viewModel = viewModel

        return binding.root
    }



    override fun onStart() {
        super.onStart()
        getMovies()
        listMoviesObserve()
    }

    private fun getMovies() {
        viewModel.loadTopRateMovies(BuildConfig.API_KEY)
    }

    private fun initializeRecyclerView(listMovies: List<Movie>) {
        var loading = false
        val layoutManager = LinearLayoutManager(this.context)
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
//        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        binding.recyclerviewMovie.layoutManager = layoutManager
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        binding.recyclerviewMovie.setHasFixedSize(true)


//        viewAdapter = MovieAdapter(listMovies!!)
        binding.recyclerviewMovie.adapter = MovieAdapter(listMovies)
        binding.recyclerviewMovie.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = recyclerView.childCount
                val itemCount = layoutManager.itemCount
                val firstItemPosition = layoutManager.findFirstVisibleItemPosition()
                val lastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()

                Log.d("TESTE", "visibleItemCount: $visibleItemCount " +
                        "itemCount: $itemCount firstItemPosition: $firstItemPosition lastItemPosition: $lastItemPosition")

                if (!loading && (firstItemPosition + visibleItemCount >= itemCount)) {
                    loading = true

                    Toast.makeText(recyclerView.context, "Fim da Lista", Toast.LENGTH_SHORT).show()
                }


            }
        })
    }

    private fun listMoviesObserve() {
        viewModel.resultData.observeForever {
            initializeRecyclerView(it)
        }
    }
}