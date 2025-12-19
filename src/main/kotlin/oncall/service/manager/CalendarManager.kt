package oncall.service.manager

import oncall.model.Day
import oncall.model.StartDate
import java.time.DayOfWeek

object CalendarManager {

    fun generateCalendar(startDate: StartDate): List<Day> {
        val calendar = mutableListOf<Day>()
        val month = startDate.month
        var dayOfWeek = startDate.dayOfWeek
        val days = getDays(month)
        val holidays = getHolidays(month)
        for (day in 1..days) {
            val isHoliday = holidays.contains(day) ||
                    (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)
            val day = Day(month = month, day = day, dayOfWeek = dayOfWeek, isHoliday = isHoliday)
            dayOfWeek = dayOfWeek.plus(1)
            calendar.add(day)
        }
        return calendar
    }

    private fun getDays(month: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> 28
            else -> 0
        }
    }

    private fun getHolidays(month: Int): List<Int> {
        return when (month) {
            1, 3 -> listOf(1)
            5 -> listOf(5)
            6 -> listOf(6)
            8 -> listOf(15)
            10 -> listOf(3, 9)
            12 -> listOf(25)
            else -> emptyList()
        }
    }
}