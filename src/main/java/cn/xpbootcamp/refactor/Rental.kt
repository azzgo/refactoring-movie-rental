package cn.xpbootcamp.refactor

data class Rental internal constructor(val movie: Movie, val daysRented: Int) {
    fun calculateThisAmount(): Double {
        var thisAmount = 0.0
        when (movie.priceCode) {
            Movie.HISTORY -> {
                thisAmount += 2.0
                if (daysRented > 2) thisAmount += (daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> thisAmount += (daysRented * 3).toDouble()
            Movie.CAMPUS -> {
                thisAmount += 1.5
                if (daysRented > 3) thisAmount += (daysRented - 3) * 1.5
            }
        }

        return thisAmount
    }

    fun calculateFrequentRenterPoints(): Int {
        return if (movie.priceCode == Movie.NEW_RELEASE && daysRented > 1) 2 else 1
    }
}