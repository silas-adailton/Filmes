package com.oliveira.silas.cad.ui.main.user

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.domain.user.interactor.UserInteractor
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class UserViewModel(val userInteractor: UserInteractor) : ViewModel() {

    val loading = ObservableBoolean()
    var result: MutableList<User> = ObservableArrayList<User>()
    val error = ObservableField<String>()
    val empty = ObservableBoolean()
    private var list: MutableList<User>? = null
    private val disposable = CompositeDisposable()

    fun getUser() {

        disposable.add(
                userInteractor.execute(userInteractor.Request()).subscribe({user->
                    result.addAll(user)

                },{e->
                    Log.d("TESTE", e.message)
                },{

                }))




    }

    fun get() {

        launch(UI) {

            try {
                loading.set(true)

                list = async { userInteractor.getUserssssss() }.await()
                updateUi(list!!)
                delay(2000L)
                loading.set(false)


            } catch (e: Exception) {
                Log.e("TESTE", e.message)
            }
        }
    }

    suspend private fun updateUi(list: MutableList<User>) {
        withContext(UI) {

            result.clear()
            result = list
        }
    }
}