package br.com.oliveira.silas.movies.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import br.com.oliveira.silas.movies.ui.main.movie.MovieAdapter
import br.com.oliveira.silas.movies.domain.Movie
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object BindAdapters {

    @JvmStatic
    @BindingAdapter("loadRecyclerViewMovies")
    fun loadRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<Movie>?) {
        val viewAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2, 1)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)

//        viewAdapter = MovieAdapter(listMovies!!)
//        recyclerView.adapter = viewAdapter
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(imageUrl: String?) {
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/original/$imageUrl")
                .apply(
                        RequestOptions()
                                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                )
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
}