package ru.trinitydigital.currency.ui.main

import android.text.Editable
import ru.trinitydigital.currency.ui.LiveCycle

interface MainContract {

    interface View {
        fun showData(list: List<String>?)
        fun showResult(result: String)
    }

    interface Presenter : LiveCycle<View> {
        fun loadData()
        fun calculate(editable: Editable?, selectedItemPosition: Int)
    }
}