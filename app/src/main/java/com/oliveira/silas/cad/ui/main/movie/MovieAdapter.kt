package com.oliveira.silas.cad.ui.main.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ItemListMoviesBinding
import com.oliveira.silas.domain.movies.Movie

class MovieAdapter(private val listMovies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind :ItemListMoviesBinding = DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.context),
                        R.layout.item_list_movies, parent, false)

        return ViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = listMovies.get(position)
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: ItemListMoviesBinding) : RecyclerView.ViewHolder(binding.root)
}