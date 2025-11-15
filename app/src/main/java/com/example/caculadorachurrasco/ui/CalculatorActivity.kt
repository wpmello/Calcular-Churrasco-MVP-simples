package com.example.caculadorachurrasco.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.caculadorachurrasco.data.ChurrascoResult
import com.example.caculadorachurrasco.databinding.ActivityCalculatorBinding
import com.example.caculadorachurrasco.domain.CalculateItemsPerPeopleUseCase

class CalculatorActivity : AppCompatActivity(), CalculatorContract.View {

    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var presenter: CalculatorContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CalculatorPresenter(this, CalculateItemsPerPeopleUseCase())

        binding.btnCalculate.setOnClickListener {
            val peopleQuantity = binding.editQuantityPeople.text.toString().toIntOrNull()
            presenter.calculateForPeople(peopleQuantity ?: 0)
        }
    }

    override fun showResult(result: ChurrascoResult) {
        val text = """
            Carne: ${"%.2f".format(result.meatKg)} kg
            Frango: ${"%.2f".format(result.chickenKg)} kg
            Linguiça: ${"%.2f".format(result.sausageKg)} kg
            Refrigerante: ${"%.1f".format(result.sodaLiters)} L
            Cerveja: ${"%.1f".format(result.beerLiters)} L
            Gelo: ${"%.1f".format(result.iceKg)} kg
        """.trimIndent()

        binding.txtResult.text = text
    }

    override fun showInputError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}