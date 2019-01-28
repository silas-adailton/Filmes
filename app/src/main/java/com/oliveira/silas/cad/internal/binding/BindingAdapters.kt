package com.oliveira.silas.cad.internal.binding

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.oliveira.silas.cad.ui.main.MainActivity
import com.oliveira.silas.cad.ui.main.movie.MovieActivity
import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.cad.ui.main.movie.adapter.MovieAdapter
import com.oliveira.silas.cad.ui.main.movie.adapter.MoviePageAdapter
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.user.User

object bindAdapters {

    @JvmStatic
    @BindingAdapter("loadRecyclerView")
    fun loadRecyclerView(recyclerView: RecyclerView, listUser: List<User>) {
//        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = UserAdapter(listUser)
    }

    @JvmStatic
    @BindingAdapter("android:loadRecyclerViewMovies")
    fun loadRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<Movie>) {
        var loading = false
        val layoutManager = LinearLayoutManager(recyclerView.context)
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
//        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)


//        viewAdapter = MovieAdapter(listMovies!!)
        recyclerView.adapter = MovieAdapter(listMovies)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(imageUrl: String?) {
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/$imageUrl")
                .into(this)
    }

//    fun loadImage(imageView: ImageView, imageUrl: String?) {
//        Glide.with(imageView.context)
//                .load(imageUrl)
//                .into(imageView)
//    }

    @JvmStatic
    @BindingAdapter("loading")
    fun loading(view: View, value: Boolean) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }

//    @JvmStatic
//    @BindingAdapter("errorsss")
//    fun TextInputLayout.errorsss(textInputLayout: TextInputLayout, string: String?) {
//        if (string?.isEmpty()!!) {
//            textInputLayout.error = null
//        }else {
//            textInputLayout.error = string
//        }
//    }

    @JvmStatic
    @BindingAdapter("moviePageAdapter")
    fun setSectionAdapter(viewPager: ViewPager, event: Int?) {
        event?.let {
            val fm = (viewPager.context as MainActivity).supportFragmentManager
            viewPager.adapter = MoviePageAdapter(fm)
        }
    }

    @JvmStatic
    @BindingAdapter("setupWithViewPager")
    fun setupWithViewPager(tabLayout: TabLayout, viewPager: ViewPager) {
        tabLayout.setupWithViewPager(viewPager)
    }

    @JvmStatic
    @BindingAdapter("pageMargin")
    fun setPageMargin(viewPager: ViewPager, margin: Float) {
        viewPager.pageMargin = margin.toInt()
    }

    interface Testsss {

        fun loadMore()

    }
}