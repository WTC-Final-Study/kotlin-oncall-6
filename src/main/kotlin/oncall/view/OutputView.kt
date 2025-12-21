package oncall.view

import oncall.model.Day
import oncall.model.StartInfo

object OutputView {

    fun printSchedule(calendar: Map<Int, Day>,
                      schedule: Map<Int, String>,
                      startInfo: StartInfo) {
        val month = startInfo.month
        calendar.forEach { day, value ->
            val holiday = printHoliday(value)
            val dayOfWeek = printDayOfWeekKorean(value.dayOfWeek)
            val worker = schedule[day]
            println("${month}월 ${day}일 $dayOfWeek$holiday $worker")
        }
    }

    private fun printHoliday(day: Day): String {
        return if(day.isHoliday && (day.dayOfWeek in 0..4)) "(휴일)"
        else ""
    }

    private fun printDayOfWeekKorean(dayOfWeek: Int): String {
        return when(dayOfWeek) {
            0 -> "월"
            1 -> "화"
            2 -> "수"
            3 -> "목"
            4 -> "금"
            5 -> "토"
            6 -> "일"
            else -> ""
        }
    }
}