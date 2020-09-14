package ru.trinitydigital.currency.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import ru.trinitydigital.currency.R

class MainActivity : AppCompatActivity(), MainContract.View {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter?.bind(this)
        setupListeners()
        presenter?.loadData()
    }

    private fun setupListeners() {
        etValueOne.doAfterTextChanged {
            presenter?.calculate(it, spValueTwo.selectedItemPosition)
        }
    }

    override fun showData(list: List<String>?) {
        val adapter = CurrencySpinnerAdapter(applicationContext, R.layout.item_spinner, list!!)
        spValueOne.adapter = adapter
        spValueTwo.adapter = adapter
    }

    override fun showResult(result: String) {
        etValueTwo.setText(result)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbind()
    }
}