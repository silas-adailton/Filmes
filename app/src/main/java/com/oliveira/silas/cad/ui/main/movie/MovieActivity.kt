package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MovieActivity : AppCompatActivity() {

//    private lateinit var bind: ActivityMovieBinding
//    private val viewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        bind = DataBindingUtil.setContentView(this, R.layout.activity_movie)
//        bind.viewModel = viewModel

        getMovies()
    }

    private fun getMovies() {
//        viewModel.loadPopularMovies(BuildConfig.API_KEY)
    }

//    private fun initializeRecyclerView(listMovies: List<Movie>) {
//        var loading = false
//        val layoutManager = LinearLayoutManager(this)
////        recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
////        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
//        bind.recyclerviewMovie.layoutManager = layoutManager
////        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
//        bind.recyclerviewMovie.setHasFixedSize(true)
//
//
////        viewAdapter = MovieAdapter(listMovies!!)
//        bind.recyclerviewMovie.adapter = MovieAdapter(listMovies)
//        bind.recyclerviewMovie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                val visibleItemCount = recyclerView.childCount
//                val itemCount = layoutManager.itemCount
//                val firstItemPosition = layoutManager.findFirstVisibleItemPosition()
//                val lastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()
//
//                Log.d("TESTE", "visibleItemCount: $visibleItemCount " +
//                        "itemCount: $itemCount firstItemPosition: $firstItemPosition lastItemPosition: $lastItemPosition")
//
//                if (!loading && (firstItemPosition + visibleItemCount >= itemCount)) {
//                    loading = true
//
//                    Toast.makeText(recyclerView.context, "Fim da Lista", Toast.LENGTH_SHORT).show()
//                }
//
//
//            }
//        })
//    }
//
//    private fun load() {
//        viewModel.resultData.observeForever {
//            initializeRecyclerView(it)
//        }
//    }
//
//    override fun loadMore() {
////        viewModel.loadPopularMovies(BuildConfig.API_KEY)
////        Toast.makeText(this, "Chamou na Activity", Toast.LENGTH_SHORT).show()
//
//        Log.d("TESTE", "Chamou na Activity")
//
//    }


}
