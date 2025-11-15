package com.example.caculadorachurrasco.ui

import com.example.caculadorachurrasco.data.ChurrascoResult

interface CalculatorContract {
    interface View {
        fun showResult(result: ChurrascoResult)
        fun showInputError(message: String)
    }

    interface Presenter {
        fun calculateForPeople(peopleQuantity: Int)
    }
}