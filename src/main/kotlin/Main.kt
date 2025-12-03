package dev.lambo

import dev.lambo.days.DayPicker
import dev.lambo.days.one.DayOne

fun main() {
    println("Hello World!")
    println("This is my attempt at solving the Advent of Code challenges in Kotlin.")
    val toRun = DayPicker().go()

    println("Running $toRun...\t")
    val partOne = toRun.runPartOne({}.javaClass.getResourceAsStream("/${toRun.file}"))
    println("Part One Answer: $partOne")
    val partTwo = toRun.runPartTwo({}.javaClass.getResourceAsStream("/${toRun.file}"))
    println("Part Two Answer: $partTwo")

    println("All done for today! Happy Coding!")
}