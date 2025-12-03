package dev.lambo.days

import java.io.InputStream

interface Day {
    val file: String
    fun runPartOne(input: InputStream?): String
    fun runPartTwo(input: InputStream?): String
}