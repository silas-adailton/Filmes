package com.oliveira.silas.cad.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.MainFragmentBinding
import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.cad.ui.main.user.UserAdapter
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private lateinit var viewAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>
    private val disposable = CompositeDisposable()
    private lateinit var  bind: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    val userViewModel: UserViewModel by viewModel()
    val movieViewModel : MovieViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        bind = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        bind.userViewModel = userViewModel

        return bind.root

//        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        initRecyclerView()
        getUsers()
        getMovies()
//        userViewModel.getUsersCoroutines()
//        main()


    }

    private fun getUsers() {

//        disposable.add(userViewModel.getUser()!!)
        userViewModel.getUser()
//        userViewModel.get()
//            showUsers(it)

    }

    private fun initRecyclerView() {
        recyclerview_user.layoutManager = LinearLayoutManager(this.context)
        recyclerview_user.hasFixedSize()
        recyclerview_user.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
    }

    private fun showUsers(it: List<User>) {
        viewAdapter = UserAdapter(it)
        recyclerview_user.adapter = viewAdapter
    }

    private fun getMovies() {
        movieViewModel.loadMovies(BuildConfig.API_KEY)
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }

}
