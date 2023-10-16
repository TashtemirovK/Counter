package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding
import com.example.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    lateinit var binding: ActivityMainBinding
    var count = 0
    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        binding.btnIncrement.setOnClickListener {
            presenter.increment()
        }
    }

    override fun updateActualCount(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvCount.setTextColor(getColor(color))
    }
}