package days.one

import days.Day
import java.io.InputStream

class DayOne : Day {
    override val file: String
        get() = "day-one.txt"

    private val dial = Dial(50)

    override fun runPartOne(input: InputStream?): String {
        try {
            input?.bufferedReader()?.forEachLine {
                processLine(it)
            } ?: throw Exception("Input was null")
        } catch (e: Exception) {
            println("Error processing input: ${e.message}")
            return "0"
        }
        val answer = dial.setToZero.toString()
        dial.reset()
        return answer
    }

    override fun runPartTwo(input: InputStream?): String {
        try {
            input?.bufferedReader()?.forEachLine {
                processLine(it)
            } ?: throw Exception("Input was null")
        } catch (e: Exception) {
            println("Error processing input: ${e.message}")
            return "0"
        }

        val answer = (dial.passedZero).toString()
        dial.reset()
        return answer
    }

    private fun processLine(line: String) {
        val (direction, amount) = parseLine(line)
        dial.turn(direction, amount)
//        println("$line - $dial")
    }

    private fun parseLine(line: String): Pair<Direction, Int> {
        val direction = Direction.fromAbbr(line.first())
        val amount = line.drop(1).toInt()
        return Pair(direction, amount)
    }

    override fun toString(): String = "Day One: Secret Entrance"
}
