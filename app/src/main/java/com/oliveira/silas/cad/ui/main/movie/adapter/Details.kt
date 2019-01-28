package com.oliveira.silas.cad.ui.main.movie.adapter

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import com.oliveira.silas.domain.movies.Movie

class Details(var movie: Movie? = null,
              var adapterPosition: Int = -1) : ItemDetailsLookup.ItemDetails<Long>() {

    override fun getSelectionKey(): Long? {
        return movie?.id!!.toLong()
    }

    override fun getPosition(): Int {
        return adapterPosition
    }

    override fun inSelectionHotspot(e: MotionEvent): Boolean {
        return true
    }
}