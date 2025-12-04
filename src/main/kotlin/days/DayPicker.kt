package days

import days.one.DayOne
import days.two.DayTwo
import days.three.DayThree

class DayPicker {
    fun go(): Day {
        print("Please select a day to run: ")
        val dayNumber = readlnOrNull()?.toIntOrNull() ?: 1
        return parseDay(dayNumber)
    }

    private fun parseDay(dayNumber: Int): Day {
        return when (dayNumber) {
            1 -> DayOne()
            2 -> DayTwo()
            3 -> DayThree()
            else -> DayOne()
        }
    }
}
