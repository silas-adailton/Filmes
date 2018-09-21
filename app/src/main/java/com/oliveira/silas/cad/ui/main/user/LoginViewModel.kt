package com.oliveira.silas.cad.ui.main.user

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import com.oliveira.silas.cad.BR

class LoginViewModel : ViewModel() {


    val password =  ObservableField<String>()

    val email =  ObservableField<String>()

    fun validateLogin()  {

        Log.d("TESTE", email.get() + password.get())

    }
}