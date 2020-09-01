package com.alankurniadi.quotesappapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.alankurniadi.quotesappapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel()
        mainViewModel.setQuotesRandom()
        progress_random.visibility = View.VISIBLE
        mainViewModel.data.observe(this, Observer {
            if (it != null) {
                progress_random.visibility = View.GONE
                tv_quotes_main.text = it.en
            }else {
                progress_random.visibility = View.GONE
            }
        })
    }
}