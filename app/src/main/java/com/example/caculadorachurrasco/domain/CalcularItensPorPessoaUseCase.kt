package com.example.caculadorachurrasco.domain

import com.example.caculadorachurrasco.data.ChurrascoResult

class CalculateItemsPerPeopleUseCase {
    fun execute(peopleQuantity: Int): ChurrascoResult {
        val meatPerPeople = 1.0
        val chickenPerPeople = 0.20
        val sausagePerPeople = 0.15
        val sodaPerPeople = 0.5
        val beerPerPeople = 1.0
        val icePerPeople = 0.3

        return ChurrascoResult(
            meatKg = peopleQuantity * meatPerPeople,
            chickenKg = peopleQuantity * chickenPerPeople,
            sausageKg = peopleQuantity * sausagePerPeople,
            sodaLiters = peopleQuantity * sodaPerPeople,
            beerLiters = peopleQuantity * beerPerPeople,
            iceKg = peopleQuantity * icePerPeople
        )
    }
}