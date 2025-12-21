package oncall.controller

import oncall.message.InputMessage
import oncall.model.Day
import oncall.model.StartInfo
import oncall.model.WorkList
import oncall.service.CalendarManager
import oncall.service.ScheduleManager
import oncall.service.StartInfoConverter
import oncall.service.WorkListConverter
import oncall.util.InputValidator
import oncall.view.InputView
import oncall.view.OutputView

class OncallController {

    fun run() {
        val startInfo = inputStartInfo()
        val workList = inputWorkList()
        CalendarManager.generateCalendar(startInfo)
        generateSchedule(CalendarManager.getCalendar(), workList)
        OutputView.printSchedule(
            calendar = CalendarManager.getCalendar(),
            schedule = ScheduleManager.getSchedule(),
            startInfo = startInfo
        )
    }

    private fun inputStartInfo(): StartInfo {
        while (true) {
            try {
                val input = InputView.input(InputMessage.START_INFO.toString())
                InputValidator.validateStartInfo(input)
                return startInfoConversion(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun startInfoConversion(input: String): StartInfo {
        return StartInfoConverter.convert(input)
    }

    private fun inputWorkList(): WorkList {
        while (true) {
            try {
                val weekdayList = inputWeekdayList()
                InputValidator.validateWorkList(weekdayList)
                val holidayList = inputHolidayList()
                InputValidator.validateWorkList(holidayList)
                return workListConvert(
                    weekdayList = weekdayList,
                    holidayList = holidayList
                )
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun inputWeekdayList(): String {
        return InputView.input(InputMessage.WEEKDAY_LIST.toString())
    }

    private fun inputHolidayList(): String {
        return InputView.input(InputMessage.HOLIDAY_LIST.toString())
    }

    private fun workListConvert(
        weekdayList: String,
        holidayList: String
    ): WorkList {
        return WorkListConverter.convert(weekdayList, holidayList)
    }

    private fun generateSchedule(
        calendar: MutableMap<Int, Day>,
        workList: WorkList
    ) {
        ScheduleManager.generateSchedule(calendar, workList)
    }
}