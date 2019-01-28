package com.oliveira.silas.cad.ui.main.movie.adapter

import androidx.recyclerview.selection.ItemKeyProvider
import com.oliveira.silas.domain.movies.Movie

class MovieKeyProvider(val listMovies: List<Movie>) : ItemKeyProvider<Long>(SCOPE_MAPPED) {
    override fun getKey(position: Int) = listMovies[position].id.toLong()

    override fun getPosition(key: Long): Int {
        return listMovies
                .indexOf(listMovies.single { listMovies -> listMovies.id.toLong() == key })
    }
}