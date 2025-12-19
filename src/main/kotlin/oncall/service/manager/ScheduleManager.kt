package oncall.service.manager

import oncall.model.Day
import oncall.model.WorkType

object ScheduleManager {

    fun generateSchedule(calendar: List<Day>, workTurn: Map<WorkType, List<String>>): List<Day> {
        val schedule = mutableListOf<Day>()
        val weekdayTurn = workTurn[WorkType.WEEKDAY]!!.toMutableList()
        val holidayTurn = workTurn[WorkType.HOLIDAY]!!.toMutableList()
        var currentWeekdayIndex = 0
        var currentHolidayIndex = 0
        var yesterdayWorker = ""
        calendar.forEach { day ->
            var scheduleDay = day
            val type = if(day.isHoliday) WorkType.HOLIDAY else WorkType.WEEKDAY
            when(type) {
                WorkType.WEEKDAY -> {
                    var behind = 1
                    val size = weekdayTurn.size
                    while (yesterdayWorker == weekdayTurn[currentWeekdayIndex]) {
                        val tmp = weekdayTurn[currentWeekdayIndex % size]
                        weekdayTurn[currentWeekdayIndex % size ] = weekdayTurn[(currentWeekdayIndex + behind) % size]
                        weekdayTurn[(currentWeekdayIndex + behind) % size] = tmp
                        behind++
                    }
                    val name = weekdayTurn[currentWeekdayIndex]
                    yesterdayWorker = name
                    currentWeekdayIndex++
                    scheduleDay.worker = name
                }
                WorkType.HOLIDAY -> {
                    var behind = 1
                    val size = holidayTurn.size
                    while (yesterdayWorker == holidayTurn[currentHolidayIndex]) {
                        val tmp = holidayTurn[currentHolidayIndex % size]
                        holidayTurn[currentHolidayIndex % size ] = holidayTurn[(currentHolidayIndex + behind) % size]
                        holidayTurn[(currentHolidayIndex + behind) % size] = tmp
                        behind++
                    }
                    val name = holidayTurn[currentHolidayIndex]
                    yesterdayWorker = name
                    currentHolidayIndex++
                    scheduleDay.worker = name
                }
            }
            schedule.add(scheduleDay)
        }
        return schedule
    }
}