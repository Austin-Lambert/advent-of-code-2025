package days.two

import dev.lambo.days.two.SillyFinder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SillyFinderTest {
    private lateinit var sut: SillyFinder

    @Test
    fun `it will find repeated sequences in a range`() {
        sut = SillyFinder()
        val simple = "11-44"
        val answer = sut.findSingleRepeatSequences(simple)
        val expected = listOf("11", "22", "33", "44")
        assertEquals(expected, answer)

        val larger = "4984-9987"
        val answer2 = sut.findSingleRepeatSequences(larger)
        val expected2 = listOf(
            "5050", "5151", "5252", "5353", "5454", "5555", "5656", "5757", "5858", "5959",
            "6060", "6161", "6262", "6363", "6464", "6565", "6666", "6767", "6868", "6969",
            "7070", "7171", "7272", "7373", "7474", "7575", "7676", "7777", "7878", "7979",
            "8080", "8181", "8282", "8383", "8484", "8585", "8686", "8787", "8888", "8989",
            "9090", "9191", "9292", "9393", "9494", "9595", "9696", "9797", "9898"
        )
        assertEquals(expected2, answer2)
    }
}
