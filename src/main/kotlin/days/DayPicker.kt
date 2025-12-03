package dev.lambo.days

import dev.lambo.days.one.DayOne
import dev.lambo.days.two.DayTwo

class DayPicker {
    fun go(): Day {
        print("Please select a day to run: ")
        val dayNumber = readlnOrNull()?.toIntOrNull() ?: 1
        return parseDay(dayNumber)
    }

    private fun parseDay(dayNumber: Int): Day {
        return when(dayNumber) {
            1 -> DayOne()
            2 -> DayTwo()
            else -> DayOne()
        }
    }
}