package com.alankurniadi.quotesappapi.api

import com.alankurniadi.quotesappapi.model.ListEnglish
import com.alankurniadi.quotesappapi.model.Random
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    // Home Random Quotes
    @GET("quotes/random")
    fun getRandomQuotes(): Call<Random>

    //English Quotes
    @GET("quotes/lang/en")
    fun getEnglishQuotes(): Call<List<ListEnglish>>
}