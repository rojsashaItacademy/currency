package ru.trinitydigital.currency.ui

interface LiveCycle<V> {
    fun bind(view: V)
    fun unbind()
}