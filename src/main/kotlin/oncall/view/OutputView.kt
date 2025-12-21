package oncall.view

import oncall.constant.DayOfWeek
import oncall.constant.message.OutputMessage
import oncall.model.Day
import oncall.model.StartInfo

object OutputView {

    fun printSchedule(
        calendar: Map<Int, Day>,
        schedule: Map<Int, String>,
        startInfo: StartInfo
    ) {
        val month = startInfo.month
        calendar.forEach { day, value ->
            val holiday = printHoliday(value)
            val dayOfWeek = DayOfWeek.getTextById(value.dayOfWeek)
            val worker = schedule[day]
            println("${month}월 ${day}일 $dayOfWeek$holiday $worker")
        }
    }

    private fun printHoliday(day: Day): String {
        return if (day.isHoliday && (day.dayOfWeek in 0..4)) OutputMessage.HOLIDAY.toString()
        else ""
    }
}