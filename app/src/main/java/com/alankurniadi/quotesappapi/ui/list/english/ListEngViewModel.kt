package com.alankurniadi.quotesappapi.ui.list.english

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.quotesappapi.api.RetrofitConfig
import com.alankurniadi.quotesappapi.model.ListEnglish
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListEngViewModel: ViewModel() {
    val data = MutableLiveData<List<ListEnglish>>()

    fun setListEngQuotes() {
        val call= RetrofitConfig().getInstance()
        call.getEnglishQuotes().enqueue(object : Callback<List<ListEnglish>> {
            override fun onResponse(
                call: Call<List<ListEnglish>>,
                response: Response<List<ListEnglish>>
            ) {
                val body = response.body()
                data.postValue(body)
            }

            override fun onFailure(call: Call<List<ListEnglish>>, t: Throwable) {
                Log.e("ListEngViewModel", "Gagal Load Data: ${t.message}")
            }

        })
    }
}