package ru.trinitydigital.currency.ui.main

import android.text.Editable
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.trinitydigital.currency.BuildConfig
import ru.trinitydigital.currency.data.model.CurrencyModel
import ru.trinitydigital.currency.data.remote.RetrofitBuilder

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    private val values = arrayListOf<String>()

    override fun loadData() {
        RetrofitBuilder.getService()?.getCurrencies(BuildConfig.API_KEY)
            ?.enqueue(object : Callback<CurrencyModel> {
                override fun onResponse(
                    call: Call<CurrencyModel>,
                    response: Response<CurrencyModel>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()
                        workWithData(data)
                    } else {
                        Log.e("NETWORK", "NO DATA")
                    }
                }

                override fun onFailure(call: Call<CurrencyModel>, t: Throwable) {
                    Log.e("NETWORK", t.localizedMessage)
                }
            })
    }

    override fun calculate(editable: Editable?, selectedItemPosition: Int) {
        val text = editable.toString()

        if (text.isNotEmpty()) {
            val result = text.toDouble() * values[selectedItemPosition].toDouble()
            view?.showResult(result.toString())
        } else view?.showResult("")
    }

    private fun workWithData(data: CurrencyModel?) {
        val keys = data?.rates?.keySet()?.toList()

        if (keys != null) {
            for (item in keys) {
                values.add(data.rates.get(item).toString())
            }
        }

        view?.showData(keys)
    }

    override fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
}