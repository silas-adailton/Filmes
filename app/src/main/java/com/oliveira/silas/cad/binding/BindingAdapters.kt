package com.oliveira.silas.cad.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.ui.main.UserAdapter

object bindAdapters {
    @JvmStatic
    @BindingAdapter("")
    fun loadRecyclerView(recyclerView: RecyclerView, listUser: List<User>) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
//        recyclerView.adapter:
        recyclerView.setHasFixedSize(true)



//        ItemListUserBinding.bind(recyclerView)
    }
}