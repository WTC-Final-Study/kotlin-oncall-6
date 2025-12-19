package oncall.service

import oncall.model.StartDate
import java.time.DayOfWeek

object StartDateParser {

    fun parse(input: String): StartDate {
        val monthAndWeekday = input.split(",")
        val weekday = when(monthAndWeekday.last()) {
            "월" -> DayOfWeek.MONDAY
            "화" -> DayOfWeek.TUESDAY
            "수" -> DayOfWeek.WEDNESDAY
            "목" -> DayOfWeek.THURSDAY
            "금" -> DayOfWeek.FRIDAY
            "토" -> DayOfWeek.SATURDAY
            "일" -> DayOfWeek.SUNDAY
            else -> throw IllegalArgumentException()
        }
        return StartDate(
            month = monthAndWeekday.first().toInt(),
            dayOfWeek = weekday
        )
    }
}