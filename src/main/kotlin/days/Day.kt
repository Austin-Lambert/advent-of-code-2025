package days

import days.one.DayOne
import days.two.DayTwo
import days.three.DayThree
import days.four.DayFour
import java.io.InputStream

abstract class Day {
    companion object {
        fun pick(): Day {
            print("Please select a day to run: ")
            val dayNumber = readlnOrNull()?.toIntOrNull()
            return when (dayNumber) {
                1 -> DayOne()
                2 -> DayTwo()
                3 -> DayThree()
                4 -> DayFour()
                else -> DayOne()
            }
        }
    }

    abstract val file: String
    abstract fun partOne(input: InputStream?): String
    abstract fun partTwo(input: InputStream?): String

    fun run() {
        println("Running $this...\t")
        val partOne = partOne({}.javaClass.getResourceAsStream("/${this.file}"))
        println("Part One Answer: $partOne")
        val partTwo = partTwo({}.javaClass.getResourceAsStream("/${this.file}"))
        println("Part Two Answer: $partTwo")
    }
}
