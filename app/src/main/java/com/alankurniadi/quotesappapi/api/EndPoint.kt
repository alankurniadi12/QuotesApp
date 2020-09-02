package com.alankurniadi.quotesappapi.api

import com.alankurniadi.quotesappapi.model.Detail
import com.alankurniadi.quotesappapi.model.ListBosnia
import com.alankurniadi.quotesappapi.model.ListEnglish
import com.alankurniadi.quotesappapi.model.Random
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {

    // Home Random Quotes
    @GET("quotes/random")
    fun getRandomQuotes(): Call<Random>

    //English Quotes
    @GET("quotes/lang/en")
    fun getEnglishQuotes(): Call<List<ListEnglish>>

    //Bosnia Quotes
    @GET("quotes/lang/sr")
    fun getBosListQuotes(): Call<List<ListBosnia>>

    //Detail Quotes
    @GET("quotes/id/{id}")
    fun getDetailQuotes(
        @Path("id") id: String?
    ): Call<Detail>
}