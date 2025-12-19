package oncall.service.manager

import oncall.model.Day
import oncall.model.StartDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

class CalendarManagerTest {

    @Test
    fun `달력 생성 테스트`() {
        val startDate = StartDate(month = 12, dayOfWeek = DayOfWeek.FRIDAY)
        val calendar = CalendarManager.generateCalendar(startDate)

        assertThat(calendar).contains(Day(month = 12, day = 1, dayOfWeek = DayOfWeek.FRIDAY, isHoliday = false),
            Day(month = 12, day = 2, dayOfWeek = DayOfWeek.SATURDAY, isHoliday = true))
    }
}