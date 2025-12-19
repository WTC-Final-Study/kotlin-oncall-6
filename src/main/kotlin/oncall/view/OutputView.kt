package oncall.view

import oncall.model.Day
import java.time.DayOfWeek

object OutputView {

    fun printSchedule(schedule: List<Day>) {
        schedule.forEach { day ->
            val holiday = if(isPrintHoliday(day)) "(휴일)" else ""
            val dayOfWeekKr = printDayOfWeekKR(day.dayOfWeek)
            println("${day.month}월 ${day.day}일 $dayOfWeekKr$holiday ${day.worker}")
        }
    }

    private fun isPrintHoliday(day: Day): Boolean {
        return day.isHoliday &&
                (day.dayOfWeek != DayOfWeek.SATURDAY && day.dayOfWeek != DayOfWeek.SUNDAY)
    }

    private fun printDayOfWeekKR(dayOfWeek: DayOfWeek): String {
        return when (dayOfWeek) {
            DayOfWeek.MONDAY -> "월"
            DayOfWeek.TUESDAY -> "화"
            DayOfWeek.WEDNESDAY -> "수"
            DayOfWeek.THURSDAY -> "목"
            DayOfWeek.FRIDAY -> "금"
            DayOfWeek.SATURDAY -> "토"
            DayOfWeek.SUNDAY -> "일"
        }
    }
}