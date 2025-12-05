package days.one

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

class DayOneTest {
    @Nested
    inner class PartOne {
        @Test
        fun `it will pass the challenge test case`() {
            val sut = DayOne()
            val resource = javaClass.getResourceAsStream("/day-one-test.txt")
            val answer = sut.partOne(resource)
            assertEquals(3, answer.toInt())
        }

        @Test
        fun `it will handle a simple case`() {
            val sut = DayOne()
            val input = """
            R10
            L60
            R5
            L5
        """.trimIndent().byteInputStream()
            val answer = sut.partOne(input)
            assertEquals(2, answer.toInt())
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `it will pass the challenge test case`() {
            val sut = DayOne()
            val resource = javaClass.getResourceAsStream("/day-one-test.txt")
            val answer = sut.partTwo(resource)
            assertEquals(6, answer.toInt())
        }

        @Test
        fun `it will handle a simple case`() {
            val sut = DayOne()
            val input = """
            R10
            L65
            R7
            L15
        """.trimIndent().byteInputStream()
            val answer = sut.partTwo(input)
            assertEquals(3, answer.toInt())
        }
    }
}
