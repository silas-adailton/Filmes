package com.oliveira.silas.cad.ui.main.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.oliveira.silas.cad.BuildConfig
import com.oliveira.silas.cad.R
import com.oliveira.silas.cad.databinding.ActivityMovieBinding
import com.oliveira.silas.cad.databinding.FragmentTopRateBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TopRateFragment : Fragment() {

    private lateinit var binding: FragmentTopRateBinding
    private val viewModel: MovieViewModel by viewModel()

    companion object {

        @JvmStatic
        fun newInstance(): TopRateFragment {
            val fragment = TopRateFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rate, container, false)
        binding.viewModel = viewModel

        return binding.root
    }



    override fun onStart() {
        super.onStart()
        getMovies()
    }

    private fun getMovies() {
        viewModel.loadTopRateMovies(BuildConfig.API_KEY)
    }
}