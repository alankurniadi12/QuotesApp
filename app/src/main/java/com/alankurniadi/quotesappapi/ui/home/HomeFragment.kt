package com.alankurniadi.quotesappapi.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alankurniadi.quotesappapi.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = HomeViewModel()
        homeViewModel.setQuotesRandom()
        progress_random.visibility = View.VISIBLE
        homeViewModel.data.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                progress_random.visibility = View.GONE
                tv_quotes_main.text = it.en
            }else {
                progress_random.visibility = View.GONE
                tv_quotes_main.text = resources.getString(R.string.data_kosong)
            }
        })
    }

}