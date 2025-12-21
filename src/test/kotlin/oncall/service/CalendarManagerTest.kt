package oncall.service

import oncall.constant.DayOfWeek
import oncall.model.Day
import oncall.model.StartInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalendarManagerTest {

    @Test
    fun `달력이 정상적으로 생성된다`() {
        val startInfo = StartInfo(
            month = 5,
            dayOfWeek = DayOfWeek.MONDAY
        )
        CalendarManager.generateCalendar(startInfo)
        val calendar = CalendarManager.getCalendar().get(5)
        val childDay = Day(
            day = 5,
            isHoliday = true,
            dayOfWeek = DayOfWeek.FRIDAY
        )
        CalendarManager.getCalendar().forEach { calendar ->
            println(calendar.value)
        }
        assertEquals(calendar, childDay)
    }
}