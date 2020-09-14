package ru.trinitydigital.currency.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.trinitydigital.currency.R

class SecondActivity : AppCompatActivity(), SecondContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}