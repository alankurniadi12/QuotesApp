package com.alankurniadi.quotesappapi.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.quotesappapi.api.RetrofitConfig
import com.alankurniadi.quotesappapi.model.Detail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    val data = MutableLiveData<Detail>()

    fun setDetailQuotes(id: String) {
        val call = RetrofitConfig().getInstance()
        call.getDetailQuotes(id).enqueue(object : Callback<Detail> {
            override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                val body = response.body()
                data.postValue(body)
            }

            override fun onFailure(call: Call<Detail>, t: Throwable) {
                Log.e("DetailViewModel", "Gagal Load Data: ${t.message}")
            }

        })
    }
}