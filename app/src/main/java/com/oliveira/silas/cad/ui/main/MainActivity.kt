package com.oliveira.silas.cad.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.oliveira.silas.cad.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val moviePageAdapter = MoviePageAdapter(supportFragmentManager, 2)

        viewPager.adapter = moviePageAdapter

        tabs.setupWithViewPager(viewPager)
    }
}
