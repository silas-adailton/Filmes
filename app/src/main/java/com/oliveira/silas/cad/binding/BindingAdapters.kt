package com.oliveira.silas.cad.binding

import android.view.View
import android.view.animation.GridLayoutAnimationController
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.*
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout
import com.oliveira.silas.cad.ui.main.MainActivity
import com.oliveira.silas.cad.ui.main.MoviePageAdapter
import com.oliveira.silas.cad.ui.main.movie.MovieAdapter
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.cad.ui.main.user.UserAdapter
import com.oliveira.silas.domain.movies.Movie

object bindAdapters {
    @JvmStatic
    @BindingAdapter("loadRecyclerView")
    fun loadRecyclerView(recyclerView: RecyclerView, listUser: List<User>) {
//        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = UserAdapter(listUser)
    }

    @JvmStatic
    @BindingAdapter("loadRecyclerViewMovies")
    fun loadRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<Movie>) {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)


//        viewAdapter = MovieAdapter(listMovies!!)
        recyclerView.adapter = MovieAdapter(listMovies)
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
            viewPager.adapter = MoviePageAdapter(fm, it)
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
}