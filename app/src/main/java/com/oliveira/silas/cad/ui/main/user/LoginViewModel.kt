package com.oliveira.silas.cad.ui.main.user

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.BR

class LoginViewModel : ViewModel(){
//    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
//
//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        callbacks.remove(callback)
//    }
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        callbacks.add(callback)
//    }
//
//    fun notifyChange() {
//        callbacks.notifyCallbacks(this, BR._all, null)
//    }
//
//    fun notifyPropertyChanged(fieldId: Int) {
//        callbacks.notifyCallbacks(this, fieldId, null)
//
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//
//        notifyPropertyChanged(BR._all)
//    }
//
//    @Bindable
//    val password =  ObservableField<String>()
//    @Bindable
//    val email =  ObservableField<String>()
//
//    fun validateLogin() : Boolean {
//
//        if (password.get().equals("123")) {
//
//            Log.d("TESTE", password.get())
//            Log.d("TESTE", email.get())
//
//            Log.d("TESTE", "Login OK")
//            return true
//        }
//        Log.d("TESTE", password.get().toString())
//        Log.d("TESTE", "Login com bug")
//        return false
//
////       return password.get().equals("123")
//    }
}