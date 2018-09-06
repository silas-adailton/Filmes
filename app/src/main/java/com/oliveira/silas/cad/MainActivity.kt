package com.oliveira.silas.cad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliveira.silas.cad.ui.main.MainFragment
import com.oliveira.silas.cad.ui.main.user.UserViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
