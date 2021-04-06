package cn.xpbootcamp.refactor

import java.util.*
import kotlin.text.StringBuilder

class Customer internal constructor(val name: String) {
    private val rentals = Vector<Rental>()

    fun addRental(rental: Rental) {
        rentals.addElement(rental)
    }

    fun statement(): String {
        val result = StringBuilder(getNameStatement())

        result.append(getRentalStatement())
        result.append(getTotalAmountStatement())
        result.append(getFrequentRenterPointsStatement())
        return result.toString()
    }

    private fun getNameStatement() = "Rental Record for $name：\n"

    private fun getRentalStatement(): String {
        return rentals.map() {
            "\t${it.movie.title}\t${it.calculateThisAmount()}\n"
        }.joinToString("")
    }


    private fun getTotalAmountStatement(): String {
        val totalAmount = rentals.sumByDouble { it.calculateThisAmount() }
        return "Amount owed is $totalAmount\n"
    }

    private fun getFrequentRenterPointsStatement(): String {
        val frequentRenterPoints = rentals.sumBy { it.calculateFrequentRenterPoints() }
        return "You earned $frequentRenterPoints frequent renter points"
    }
}