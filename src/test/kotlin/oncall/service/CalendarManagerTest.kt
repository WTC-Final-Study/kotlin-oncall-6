package oncall.service

import oncall.model.Day
import oncall.model.StartInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalendarManagerTest {

    @Test
    fun `달력이 정상적으로 생성된다`() {
        val startInfo = StartInfo(
            month = 5,
            dayOfWeek = 0
        )
        val calendarManager = CalendarManager()
        calendarManager.generateCalendar(startInfo)
        val calendar = calendarManager.getCalendar().get(5)
        val childDay = Day(
            day = 5,
            isHoliday = true,
            dayOfWeek = 4,
            worker = ""
        )
        calendarManager.getCalendar().forEach { calendar ->
            println(calendar.value.dayOfWeek)
        }
        assertEquals(calendar, childDay)
    }
}