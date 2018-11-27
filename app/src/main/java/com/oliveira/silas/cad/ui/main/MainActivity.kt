package com.oliveira.silas.cad.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.ui.main.movie.adapter.MoviePageAdapter
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val moviePageAdapter = MoviePageAdapter(supportFragmentManager)

        viewPager.adapter = moviePageAdapter

        tabs.setupWithViewPager(viewPager)
    }
}
