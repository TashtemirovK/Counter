package com.example.view

interface CounterView {
    fun updateActualCount(count: Int)
    fun showToast(message: String)
    fun changeColor(color: Int)
}