package oncall.service

import oncall.model.Day
import oncall.model.StartInfo

object CalendarManager {

    private val calendar = mutableMapOf<Int, Day>()

    fun getCalendar() = calendar

    fun generateCalendar(startInfo: StartInfo) {
        val maxDayInMonth = getMaxDayInMonth(startInfo.month)
        val publicHolidayInMonth = getPublicHolidayInMonth(startInfo.month)
        var dayOfWeekCounter = startInfo.dayOfWeek
        for (i in 1..maxDayInMonth) {
            val day = Day(
                day = i,
                isHoliday = isHoliday(publicHolidayInMonth, dayOfWeekCounter, i),
                dayOfWeek = dayOfWeekCounter
            )
            calendar[i] = day
            dayOfWeekCounter = (dayOfWeekCounter + 1) % 7
        }
    }

    private fun isHoliday(
        publicHolidayInMonth: List<Int>,
        dayOfWeek: Int,
        day: Int
    ): Boolean {
        return publicHolidayInMonth.contains(day) ||
                dayOfWeek in 5..6
    }

    private fun getMaxDayInMonth(month: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> 28
            else -> 0
        }
    }

    private fun getPublicHolidayInMonth(month: Int): List<Int> {
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