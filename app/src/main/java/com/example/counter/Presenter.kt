package com.example.counter

import com.example.model.CounterModel
import com.example.view.CounterView

class Presenter {

    var model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        showToast()
        changeColor()
        view.updateActualCount(model.count)
    }

    private fun showToast() {
        if (model.count == 10)
            view.showToast("Поздравляем")
    }

    private fun changeColor() {
        if (model.count in -15..15) {
            view.changeColor(R.color.black)
        } else {
            view.changeColor(R.color.turquoise)
        }
    }

    fun attachView(view: CounterView) {
        this.view = view
    }
}