package oncall.service

import oncall.model.StartDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import kotlin.math.exp

class StartDateParserTest {

    @Test
    fun `입력된 월의 값이 정상적으로 추출된다`() {
        val input = StartDateParser.parse("12,금")
        val expected = StartDate(12, DayOfWeek.FRIDAY)
        assertEquals(input.month, expected.month)
    }

    @Test
    fun `입력된 요일의 값이 정상적으로 추출된다`() {
        val input = StartDateParser.parse("12,금")
        val expected = StartDate(12, DayOfWeek.FRIDAY)
        assertEquals(input.dayOfWeek, expected.dayOfWeek)
    }
}