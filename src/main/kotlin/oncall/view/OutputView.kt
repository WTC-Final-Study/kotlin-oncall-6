package oncall.view

import oncall.constants.OutputMsg
import oncall.domain.model.DaySchedule

object OutputView {

    fun workDayPrompt() {
        print(OutputMsg.WORK_DAY_PROMPT)
    }

    fun weekdayWorkPrompt() {
        print(OutputMsg.WEEKDAY_WORK_PROMPT)
    }

    fun weekendWorkPrompt() {
        print(OutputMsg.WEEKEND_WORK_PROMPT)
    }

    fun displaySchedule(schedule: List<DaySchedule>) {
        schedule.forEach {
            if (it.isWeekday && it.isPublicHoliday) {
                println(OutputMsg.HOLIDAY_SCHEDULE.format(it.month, it.date, it.dayOfWeek, it.name))
            } else {
                println(OutputMsg.DEFAULT_SCHEDULE.format(it.month, it.date, it.dayOfWeek, it.name))
            }
        }
    }

    fun displayError(message: String) {
        println(message)
    }
}
