package com.alankurniadi.quotesappapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitConfig {
    private fun retrofitQuotes(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): EndPoint {
        return retrofitQuotes().create(EndPoint::class.java)
    }
}