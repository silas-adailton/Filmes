package com.oliveira.silas.cad.ui.main.user

import android.util.Log
import androidx.databinding.*
import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.BR
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.domain.user.interactor.UserInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableMaybeObserver

class UserViewModel(val userInteractor: UserInteractor) : ViewModel(), Observable {

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    @Bindable
    val loading = ObservableBoolean()
    @Bindable
    var result: MutableList<User> = ObservableArrayList<User>()
    val error = ObservableField<String>()
    val empty = ObservableBoolean()

    private val disposable = CompositeDisposable()

    fun getUser() {
        return userInteractor.execute(userInteractor.Request())
                .subscribe(object : DisposableMaybeObserver<List<User>>() {

                    override fun onStart() {
                        loading.set(true)
                    }

                    override fun onSuccess(user: List<User>) {
                        loading.set(false)
                        result.clear()
                        result.addAll(user)

                        notifyChange()
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        loading.set(false)
                        Log.d("TESTE", e.message)
                    }

                })


//        loading.set(true)
//
//        disposable.add(
//                userInteractor.execute(userInteractor.Request())
//                        .subscribe({ user ->
//                            result.clear()
//                            result.addAll(user)
//
//                            loading.set(false)
//
//                        }, { e ->
//                            loading.set(false)
//                            Log.d("TESTE", e.message)
//                        }))


    }

//    fun get() {
//
//        launch(UI) {
//
//            try {
//                loading.set(true)
//
//                result = async { userInteractor.getUserssssss() }.await()
//                updateUi(result)
//                delay(2000L)
//                loading.set(false)
//
//
//            } catch (e: Exception) {
//                Log.e("TESTE", e.message)
//            }
//        }
//    }
//
//    suspend private fun updateUi(list: MutableList<User>) {
//        withContext(UI) {
//
//            result.clear()
//            result = list
//        }
//    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, BR._all, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)

    }

    override fun onCleared() {
        super.onCleared()

        notifyPropertyChanged(BR._all)
    }
}