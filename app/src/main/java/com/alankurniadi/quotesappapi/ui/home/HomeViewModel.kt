package com.alankurniadi.quotesappapi.ui.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.quotesappapi.api.RetrofitConfig
import com.alankurniadi.quotesappapi.model.Random
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    val data = MutableLiveData<Random>()

    fun setQuotesRandom() {
        val call = RetrofitConfig().getInstance()
        call.getRandomQuotes().enqueue(object : Callback<Random> {
            override fun onResponse(call: Call<Random>, response: Response<Random>) {
                val body = response.body()
                data.postValue(body)
            }

            override fun onFailure(call: Call<Random>, t: Throwable) {
                Log.e("MainViewModel", "Gagal Load Data: ${t.message}")
            }

        })
    }
}