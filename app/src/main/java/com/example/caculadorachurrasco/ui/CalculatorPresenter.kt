package com.example.caculadorachurrasco.ui

import com.example.caculadorachurrasco.domain.CalculateItemsPerPeopleUseCase

class CalculatorPresenter(
    private val view: CalculatorContract.View,
    private val useCase: CalculateItemsPerPeopleUseCase
) : CalculatorContract.Presenter {
    override fun calculateForPeople(peopleQuantity: Int) {
        if (peopleQuantity <= 0) {
            view.showInputError("Informe um número válido de pessoas!")
            return
        }

        val result = useCase.execute(peopleQuantity)
        view.showResult(result)
    }
}