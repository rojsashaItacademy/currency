package ru.trinitydigital.currency.ui.second

import androidx.lifecycle.Lifecycle
import ru.trinitydigital.currency.ui.LiveCycle

interface SecondContract {

    interface View {

    }

    interface Presenter : LiveCycle<View> {

    }
}