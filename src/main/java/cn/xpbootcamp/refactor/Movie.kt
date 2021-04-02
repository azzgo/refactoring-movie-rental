package cn.xpbootcamp.refactor

class Movie internal constructor(val title: String, val priceCode: Int) {

    companion object {
        const val CAMPUS = 2
        const val HISTORY = 0
        const val NEW_RELEASE = 1
    }
}