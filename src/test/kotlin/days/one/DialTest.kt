package days.one

import days.one.Dial
import days.one.Direction
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DialTest {
    private lateinit var sut: Dial

    @Test
    fun `it will turn right`() {
        sut = Dial(50)
        assertEquals(50, sut.setting)
        sut.turn(Direction.RIGHT, 1)
        assertEquals(51, sut.setting)
    }

    @Test
    fun `it will turn left`() {
        sut = Dial(50)
        assertEquals(50, sut.setting)
        sut.turn(Direction.LEFT, 1)
        assertEquals(49, sut.setting)
    }

    @Test
    fun `it will wrap around correctly`() {
        sut = Dial(99)
        sut.turn(Direction.RIGHT, 1)
        assertEquals(0, sut.setting)
        sut.turn(Direction.LEFT, 1)
        assertEquals(99, sut.setting)
    }

    @Test
    fun `it will handle large turns correctly`() {
        sut = Dial(0)
        sut.turn(Direction.RIGHT, 250)
        assertEquals(50, sut.setting)
        sut.turn(Direction.LEFT, 125)
        assertEquals(25, sut.setting)
    }

    @Test
    fun `it will count the times it was set to 0`() {
        sut = Dial(3)
        sut.turn(Direction.LEFT, 3)
        assertEquals(0, sut.setting)
        assertEquals(1, sut.setToZero)
        sut.turn(Direction.RIGHT, 100)
        assertEquals(0, sut.setting)
        assertEquals(2, sut.setToZero)
    }

    @Test
    fun `it will count the times it passed 0`() {
        sut = Dial(98)
        sut.turn(Direction.RIGHT, 5)
        assertEquals(3, sut.setting)
        assertEquals(1, sut.passedZero)
        sut.turn(Direction.LEFT, 10)
        assertEquals(93, sut.setting)
        assertEquals(2, sut.passedZero)
        sut.turn(Direction.LEFT, 95)
        assertEquals(98, sut.setting)
        assertEquals(3, sut.passedZero)
        sut.turn(Direction.RIGHT, 2)
        assertEquals(0, sut.setting)
        assertEquals(4, sut.passedZero)
        sut.turn(Direction.LEFT, 50)
        assertEquals(50, sut.setting)
        assertEquals(4, sut.passedZero)
    }
}
