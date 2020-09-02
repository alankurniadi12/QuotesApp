package com.alankurniadi.quotesappapi.ui.list.bosnia

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.quotesappapi.api.RetrofitConfig
import com.alankurniadi.quotesappapi.model.ListBosnia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListBosViewModel: ViewModel() {
    val data = MutableLiveData<List<ListBosnia>>()

    fun setListBosQuotes() {
        val call = RetrofitConfig().getInstance()
        call.getBosListQuotes().enqueue(object : Callback<List<ListBosnia>> {
            override fun onResponse(
                call: Call<List<ListBosnia>>,
                response: Response<List<ListBosnia>>
            ) {
                val body = response.body()
                data.postValue(body)
            }

            override fun onFailure(call: Call<List<ListBosnia>>, t: Throwable) {
                Log.e("ListBosViewModel", "Gagal Load Data: ${t.message}")
            }

        })
    }
}