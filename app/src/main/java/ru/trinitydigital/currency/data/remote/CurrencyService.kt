package ru.trinitydigital.currency.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.trinitydigital.currency.data.model.CurrencyModel

interface CurrencyService {
    @GET("latest")
    fun getCurrencies(@Query("access_key") key: String): Call<CurrencyModel>
}