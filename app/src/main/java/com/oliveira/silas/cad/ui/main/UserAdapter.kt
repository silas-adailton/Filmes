package com.oliveira.silas.cad.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.domain.User
import kotlinx.android.synthetic.main.item_list_user.view.*

class UserAdapter(private val listUser: MutableList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = listUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textViewName.text = listUser.get(position).toString()
        holder.textViewAge.text = listUser.get(position).toString()
        holder.textViewId.text = listUser.get(position).toString()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.textView_name
        val textViewAge = itemView.textView_age
        val textViewId = itemView.textView_id
    }
}