package oncall.service.parser

import oncall.model.StartDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

class StartDateParserTest {

    @Test
    fun `입력된 월의 값이 정상적으로 추출된다`() {
        val input = StartDateParser.parse("12,금")
        val expected = StartDate(12, DayOfWeek.FRIDAY)
        Assertions.assertEquals(input.month, expected.month)
    }

    @Test
    fun `입력된 요일의 값이 정상적으로 추출된다`() {
        val input = StartDateParser.parse("12,금")
        val expected = StartDate(12, DayOfWeek.FRIDAY)
        Assertions.assertEquals(input.dayOfWeek, expected.dayOfWeek)
    }
}