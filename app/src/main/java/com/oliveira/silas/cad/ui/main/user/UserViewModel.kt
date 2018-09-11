package com.oliveira.silas.cad.ui.main.user

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.domain.User
import com.oliveira.silas.cad.domain.UserInteractor
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver

class UserViewModel(val userInteractor: UserInteractor) : ViewModel() {

//    fun getUser() = userInteractor.getUserInteractor()

    val loading = ObservableBoolean()
    var result: MutableList<User> = ObservableArrayList<User>()
    val error = ObservableField<String>()
    val empty = ObservableBoolean()

    fun getUser(): Disposable? {

        return userInteractor.getUserInteractor().subscribeWith(object : DisposableMaybeObserver<List<User>>() {
            override fun onStart() {
                super.onStart()
            }

            override fun onSuccess(t: List<User>) {
                result.clear()
                result.addAll(t)
            }

            override fun onError(e: Throwable) {
                Log.d("TESTE",e.message)
            }

            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

//        return userInteractor.getUserInteractor().subscribe {
//            result.clear()
//            result.addAll(it)
//        }
    }
}