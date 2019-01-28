package com.oliveira.silas.cad.ui.main.movie.adapter

import androidx.recyclerview.selection.SelectionTracker

class MoviePredicate : SelectionTracker.SelectionPredicate<Long>() {
    override fun canSelectMultiple() = true

    override fun canSetStateForKey(key: Long, nextState: Boolean) = true

    override fun canSetStateAtPosition(position: Int, nextState: Boolean) = true
}