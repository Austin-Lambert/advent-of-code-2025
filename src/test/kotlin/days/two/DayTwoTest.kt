package days.two

import days.two.DayTwo
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayTwoTest {
    private lateinit var sut: DayTwo

    @Nested
    inner class PartOne {
        @Test
        fun `it will pass the challenge test case`() {
            sut = DayTwo()
            val resource = javaClass.getResourceAsStream("/day-two-test.txt")
            val answer = sut.runPartOne(resource)
            assertEquals("1227775554", answer)
        }

        @Test
        fun `it will handle a simple case`() {
            sut = DayTwo()
            val input = "11-22".trimIndent().byteInputStream()
            val answer = sut.runPartOne(input)
            assertEquals("33", answer)
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `it will pass the challenge test case`() {
            sut = DayTwo()
            val resource = javaClass.getResourceAsStream("/day-two-test.txt")
            val answer = sut.runPartTwo(resource)
            assertEquals("4174379265", answer)
        }

        @Test
        fun `it will handle a simple case`() {
            sut = DayTwo()
            val input = "11-44,540-675".trimIndent().byteInputStream()
            val answer = sut.runPartTwo(input)
            assertEquals((11 + 22 + 33 + 44 + 555 + 666).toString(), answer) // 11 + 22 + 33 + 44 + 555 + 666
        }
    }
}
