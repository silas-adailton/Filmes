package com.oliveira.silas.cad.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliveira.silas.cad.MainActivity
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance() = MainFragment()
    }

//    private lateinit var viewModel: MainViewModel
//    val userViewModel = inject<UserViewModel>()
      val userViewModel: UserViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        userViewModel.value.getUser()
//        Log.i("TESTE","ViewModel : ${userViewModel.value.sayHello()}")
//        Log.i("TESTE","Firebase : ${userViewModel.value.getUser()}")

//        userViewModel.value.getUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { user -> user.get(0).name }.isDisposed
        // TODO: Use the ViewModel


        userViewModel.getUser().subscribe {

            initRecyclerView(it)
            for (user: User in it) {
                Log.d("TESTE", "Id: "+user.id+" - Nome: "+user.name+" - Idade: "+user.age)
            }
        }.isDisposed



    }

    fun initRecyclerView(it: List<User>) {

//        recyclerView.adapter = UserAdapter(it as MutableList<User>)
        recyclerView.layoutManager = viewManager
        viewManager = LinearLayoutManager(this.context)
        viewAdapter = UserAdapter(it as MutableList<User>)
    }

}
