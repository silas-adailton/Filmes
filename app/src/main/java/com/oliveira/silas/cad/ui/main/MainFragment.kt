package com.oliveira.silas.cad.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    val userViewModel = inject<UserViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        userViewModel.value.getUser()
//        Log.i("TESTE","ViewModel : ${userViewModel.value.sayHello()}")
        Log.i("TESTE","Firebase : ${userViewModel.value.getUser()}")

//        userViewModel.value.getUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { user -> user.get(0).name }.isDisposed
        // TODO: Use the ViewModel



    }

}
