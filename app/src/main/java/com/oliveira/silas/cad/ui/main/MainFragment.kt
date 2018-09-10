package com.oliveira.silas.cad.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private lateinit var viewAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>

    companion object {
        fun newInstance() = MainFragment()
    }

    val userViewModel: UserViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        getUsers()

    }

    private fun getUsers() {
        userViewModel.getUser().subscribe {
            showUsers(it)
        }.isDisposed
    }

    private fun initRecyclerView() {
        recyclerview_user.layoutManager = LinearLayoutManager(this.context)
        recyclerview_user.hasFixedSize()
    }

    private fun showUsers(it: List<User>) {
        viewAdapter = UserAdapter(it)
        recyclerview_user.adapter = viewAdapter
    }

}
