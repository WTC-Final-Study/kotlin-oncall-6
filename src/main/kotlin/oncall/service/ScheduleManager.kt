package oncall.service

import oncall.model.Day
import oncall.model.WorkList

object ScheduleManager {

    private val schedule = mutableMapOf<Int, String>()

    var currentHolidayIndex = 0
    var currentWeekdayIndex = 0

    fun getSchedule() = schedule

    fun generateSchedule(calendar: Map<Int, Day>, workList: WorkList) {
        var holidayList = workList.holiday
        var weekdayList = workList.weekday
        calendar.forEach { day, value ->
            if (value.isHoliday) {
                holidayList = pickWorker(holidayList, currentHolidayIndex, day)
                currentHolidayIndex = (currentHolidayIndex + 1) % (holidayList.size - 1)
            } else {
                weekdayList = pickWorker(weekdayList, currentWeekdayIndex, day)
                currentWeekdayIndex = (currentWeekdayIndex + 1) % (weekdayList.size - 1)
            }
        }
    }

    private fun pickWorker(
        workList: MutableList<String>,
        index: Int,
        day: Int
    ): MutableList<String> {
        var swapIndexCount = 1
        while (true) {
            if(!isSameWorkerYesterday(workList[index], day)) break
            val swapTarget = workList[index]
            val swapIndex = (index + swapIndexCount) % (workList.size - 1)
            workList[index] = workList[swapIndex]
            workList[swapIndex] = swapTarget
            swapIndexCount++
        }
        val pickWorker = workList[index]
        schedule[day] = pickWorker
        return workList
    }

    private fun isSameWorkerYesterday(worker: String, day: Int): Boolean {
        if (schedule.isEmpty()) return false
        return schedule[day - 1] == worker
    }
}