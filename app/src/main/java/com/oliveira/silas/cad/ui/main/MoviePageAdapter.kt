package com.oliveira.silas.cad.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.oliveira.silas.cad.ui.main.movie.PopularFragment
import com.oliveira.silas.cad.ui.main.movie.TopRateFragment

class MoviePageAdapter(fm: FragmentManager, val movie : Int) : FragmentPagerAdapter(fm) {
    private val items = arrayOf("Popular", "Top Rate")
    override fun getItem(position: Int): Fragment {
       return when(position) {
           0 -> PopularFragment.newInstance()
           1 -> TopRateFragment.newInstance()
           else -> Fragment()
       }
    }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int): CharSequence? {
        return items.get(position)
    }
}