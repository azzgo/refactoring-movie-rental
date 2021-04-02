package cn.xpbootcamp.refactor

import java.lang.StringBuilder
import java.util.*

class Customer internal constructor(val name: String) {
    private val rentals = Vector<Rental>()
    fun addRental(rental: Rental) {
        rentals.addElement(rental)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        val rentals = rentals.elements()
        val result = StringBuilder("Rental Record for $name：\n")
        while (rentals.hasMoreElements()) {
            val each = rentals.nextElement()
            //show figures for this rental
            //determine amounts for each line
            var thisAmount = 0.0
            when (each.movie.priceCode) {
                Movie.HISTORY -> {
                    thisAmount += 2.0
                    if (each.daysRented > 2) thisAmount += (each.daysRented - 2) * 1.5
                }
                Movie.NEW_RELEASE -> thisAmount += (each.daysRented * 3).toDouble()
                Movie.CAMPUS -> {
                    thisAmount += 1.5
                    if (each.daysRented > 3) thisAmount += (each.daysRented - 3) * 1.5
                }
            }
            //add frequent renter points
            frequentRenterPoints++
            if (each.movie.priceCode == Movie.NEW_RELEASE && each.daysRented > 1) frequentRenterPoints++

            //show figures for this rental
            result.append("\t")
                .append(each.movie.title)
                .append("\t")
                .append(thisAmount).append("\n")
            totalAmount += thisAmount
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n")
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points")
        return result.toString()
    }
}