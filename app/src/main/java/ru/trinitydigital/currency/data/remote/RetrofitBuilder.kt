package ru.trinitydigital.currency.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.trinitydigital.currency.BuildConfig.BASE_URL

object RetrofitBuilder {

    private var service: CurrencyService? = null

    fun getService(): CurrencyService? {
        if (service == null)
            service = buildRetrofit()

        return service
    }

    private fun buildRetrofit(): CurrencyService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyService::class.java)
    }
}