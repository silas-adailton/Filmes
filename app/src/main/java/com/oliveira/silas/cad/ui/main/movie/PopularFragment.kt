package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy.createLongStorage
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.FragmentPopularBinding
import com.oliveira.silas.cad.ui.main.movie.adapter.Detailslookup
import com.oliveira.silas.cad.ui.main.movie.adapter.MovieAdapter
import com.oliveira.silas.cad.ui.main.movie.adapter.MovieKeyProvider
import com.oliveira.silas.cad.ui.main.movie.adapter.MoviePredicate
import com.oliveira.silas.domain.movies.Movie
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.viewmodel.ext.android.viewModel


class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    lateinit var selectionTracker: SelectionTracker<Long>
    private val viewModel: MovieViewModel by viewModel()

    companion object {

        const val SELECTION_TRACKER_KEY = "SELECTION_TRACKER_KEY"

        @JvmStatic
        fun newInstance(): PopularFragment {
            return PopularFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        binding.viewModel = viewModel
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        getMovies()
        listMoviesObserve()
    }

    private fun getMovies() {
        viewModel.loadPopularMovies(BuildConfig.API_KEY)
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
        initializeSelectionTracker(listMovies)


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
//        initializeSelectionTracker(listMovies)
    }

    private fun listMoviesObserve() {
        viewModel.resultData.observeForever {
            initializeRecyclerView(it)
        }
    }

    private fun initializeSelectionTracker(listMovies: List<Movie>) {
        selectionTracker = SelectionTracker.Builder<Long>(
                SELECTION_TRACKER_KEY,
                binding.recyclerviewMovie,
                MovieKeyProvider(listMovies),
                Detailslookup(binding.recyclerviewMovie),
                createLongStorage()
        )
//                .withSelectionPredicate(MoviePredicate())
                .build()

        (recyclerview_movie.adapter as MovieAdapter).selectionTracker = selectionTracker
    }
}
