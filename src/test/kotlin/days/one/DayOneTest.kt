package days.one

import days.one.DayOne
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

class DayOneTest {
    private lateinit var sut: DayOne

    @BeforeEach
    fun beforeEach() {
        sut = DayOne()
    }

    @Nested
    inner class PartOne {
        @Test
        fun `it will pass the challenge test case`() {
            val resource = javaClass.getResourceAsStream("/day-one-test.txt")
            val answer = sut.runPartOne(resource)
            assertEquals(3, answer.toInt())
        }

        @Test
        fun `it will handle a simple case`() {
            val input = """
            R10
            L60
            R5
            L5
        """.trimIndent().byteInputStream()
            val answer = sut.runPartOne(input)
            assertEquals(2, answer.toInt())
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `it will pass the challenge test case`() {
            val resource = javaClass.getResourceAsStream("/day-one-test.txt")
            val answer = sut.runPartTwo(resource)
            assertEquals(6, answer.toInt())
        }

        @Test
        fun `it will handle a simple case`() {
            val input = """
            R10
            L65
            R7
            L15
        """.trimIndent().byteInputStream()
            val answer = sut.runPartTwo(input)
            assertEquals(3, answer.toInt())
        }
    }
}
