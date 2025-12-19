package oncall.service.manager

import oncall.model.Day
import oncall.model.WorkType

object ScheduleManager {

    fun generateSchedule(calendar: List<Day>, workTurn: Map<WorkType, List<String>>): List<Day> {
        val weekdayTurn = workTurn[WorkType.WEEKDAY]!!.toMutableList()
        val holidayTurn = workTurn[WorkType.HOLIDAY]!!.toMutableList()
        var currentWeekdayIndex = 0
        var currentHolidayIndex = 0
        var yesterdayWorker = ""

        return calendar.map { day ->
            val (worker, newWeekdayIndex, newHolidayIndex) = pickWorker(
                day, weekdayTurn, holidayTurn, currentWeekdayIndex, currentHolidayIndex, yesterdayWorker
            )
            currentWeekdayIndex = newWeekdayIndex
            currentHolidayIndex = newHolidayIndex
            yesterdayWorker = worker
            day.apply { this.worker = worker }
        }
    }

    private fun pickWorker(
        day: Day,
        weekdayTurn: MutableList<String>,
        holidayTurn: MutableList<String>,
        weekdayIndex: Int,
        holidayIndex: Int,
        yesterdayWorker: String
    ): Triple<String, Int, Int> {
        return if (day.isHoliday) {
            val worker = pickHolidayWorker(holidayTurn, holidayIndex, yesterdayWorker)
            Triple(worker, weekdayIndex, holidayIndex + 1)
        } else {
            val worker = weekdayTurn[weekdayIndex % weekdayTurn.size]
            Triple(worker, weekdayIndex + 1, holidayIndex)
        }
    }

    private fun pickHolidayWorker(
        holidayTurn: MutableList<String>,
        index: Int,
        yesterdayWorker: String
    ): String {
        val size = holidayTurn.size
        var behind = 1

        while (yesterdayWorker == holidayTurn[index % size]) {
            swapWorkers(holidayTurn, index % size, (index + behind) % size)
            behind++
        }

        return holidayTurn[index % size]
    }

    private fun swapWorkers(list: MutableList<String>, index1: Int, index2: Int) {
        val tmp = list[index1]
        list[index1] = list[index2]
        list[index2] = tmp
    }
}