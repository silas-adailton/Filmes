package com.oliveira.silas.cad.ui.main.movie.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ItemListMoviesBinding
import com.oliveira.silas.domain.movies.Movie

class MovieAdapter(private val listMovies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var selectionTracker: SelectionTracker<Long>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind: ItemListMoviesBinding = DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.context),
                        R.layout.item_list_movies, parent, false)

        return ViewHolder(bind)
    }

    override fun getItemCount() = listMovies.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = listMovies.get(position)
        holder.binding.executePendingBindings()
        holder.binding.cardViewMovie.setOnLongClickListener {
            holder.setModel(listMovies[position], position)
            true
        }

        holder.binding.cardViewMovie.setOnClickListener { holder.setUIItemNotSelected() }

    }

    inner class ViewHolder(val binding: ItemListMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        val itemDetails: Details

        init {
            itemDetails = Details()
        }

        fun setModel(movie: Movie, position: Int) {
            itemDetails.movie = movie
            itemDetails.adapterPosition = position
            if (selectionTracker != null) {
                if (selectionTracker!!.isSelected(itemDetails.selectionKey)) {
                    itemView.isActivated = true
                    setUiItemSelected()
                }else {
                    itemView.isActivated = false
                    setUIItemNotSelected()

                }
            }


        }

        private fun setUiItemSelected() {
            itemView.setBackgroundColor(Color.GRAY)
        }

         fun setUIItemNotSelected() {
            itemView.setBackgroundColor(Color.WHITE)

        }
    }
}