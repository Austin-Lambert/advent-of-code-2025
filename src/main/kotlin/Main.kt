package dev.lambo

import dev.lambo.days.one.DayOne

fun main() {
    println("Hello World!")
    println("This is my attempt at solving the Advent of Code challenges in Kotlin.")

    // Day One
    println("---------------------\tDay 1\t---------------------")
    print("Running Day One Part One Challenge...\t")
    val answer = DayOne().runPartOne({}.javaClass.getResourceAsStream("/day-one.txt"))
    println("Answer: $answer")
    print("Running Day One Part Two Challenge...\t")
    val answerPartTwo = DayOne().runPartTwo({}.javaClass.getResourceAsStream("/day-one.txt"))
    println("Answer: $answerPartTwo")

    println("All done for today! Happy Coding!")
}