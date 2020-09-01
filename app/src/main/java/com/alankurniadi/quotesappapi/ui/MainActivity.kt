package com.alankurniadi.quotesappapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        mainViewModel.data.observe(this, Observer {
            if (it != null) {
                tv_quotes_main.text = it.en
            }
        })
    }
}