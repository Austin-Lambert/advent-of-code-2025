package days.two

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayTwoTest {
    @Nested
    inner class PartOne {
        @Test
        fun `it will pass the challenge test case`() {
            val sut = DayTwo()
            val resource = javaClass.getResourceAsStream("/day-two-test.txt")
            val answer = sut.partOne(resource)
            assertEquals("1227775554", answer)
        }

        @Test
        fun `it will handle a simple case`() {
            val sut = DayTwo()
            val input = "11-22".trimIndent().byteInputStream()
            val answer = sut.partOne(input)
            assertEquals("33", answer)
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `it will pass the challenge test case`() {
            val sut = DayTwo()
            val resource = javaClass.getResourceAsStream("/day-two-test.txt")
            val answer = sut.partTwo(resource)
            assertEquals("4174379265", answer)
        }

        @Test
        fun `it will handle a simple case`() {
            val sut = DayTwo()
            val input = "11-44,540-675".trimIndent().byteInputStream()
            val answer = sut.partTwo(input)
            assertEquals((11 + 22 + 33 + 44 + 555 + 666).toString(), answer) // 11 + 22 + 33 + 44 + 555 + 666
        }
    }
}
