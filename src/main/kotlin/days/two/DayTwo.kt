package days.two

import days.Day
import java.io.InputStream

class DayTwo : Day() {
    override fun toString(): String = "Day 2: Gift Shop"

    override val file: String
        get() = "day-two.txt"

    override fun partOne(input: InputStream?): String {
        if (input == null) return ""
        val finder = SillyFinder()
        val range = input.bufferedReader().readLine().split(',')
        val results = range.flatMap { finder.findSingleRepeatSequences(it) }.toSet()
        return results.reduce { acc, s ->
            (acc.toLong() + s.toLong()).toString()
        }
    }

    override fun partTwo(input: InputStream?): String {
        if (input == null) return ""
        val finder = SillyFinder()
        val range = input.bufferedReader().readLine().split(',')
        val results = range.flatMap { finder.findDeepRepeatSequences(it) }.toSet()
        return results.reduce { acc, s ->
            (acc.toLong() + s.toLong()).toString()
        }
    }
}
