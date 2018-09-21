package com.oliveira.silas.cad.ui.main.user

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_bot.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding
    val viewModel: LoginViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_login)
        bind.viewModel = viewModel

         val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.d("TESTE","TESTE")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    Log.d("TESTE","TESTE")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    Log.d("TESTE","TESTE")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
