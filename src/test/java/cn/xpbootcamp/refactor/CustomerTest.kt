package cn.xpbootcamp.refactor

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions

class CustomerTest {
    @Test
    fun should_return_correct_result_when_call_statement() {
        val customer = Customer("老王")
        customer.addRental(Rental(Movie("同桌的你", Movie.CAMPUS), 4))
        customer.addRental(Rental(Movie("宠爱", Movie.NEW_RELEASE), 5))
        customer.addRental(Rental(Movie("战狼2", Movie.HISTORY), 6))
        Assertions.assertThat(
            """Rental Record for 老王：
	同桌的你	3.0
	宠爱	15.0
	战狼2	8.0
Amount owed is 26.0
You earned 4 frequent renter points"""
        ).isEqualTo(customer.statement())
    }
}