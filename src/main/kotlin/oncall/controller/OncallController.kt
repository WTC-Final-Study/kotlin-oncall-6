package oncall.controller

import oncall.message.ErrorMessage
import oncall.message.InputMessage
import oncall.model.StartDate
import oncall.model.WorkType
import oncall.service.manager.CalendarManager
import oncall.service.manager.ScheduleManager
import oncall.service.parser.StartDateParser
import oncall.service.parser.TurnParser
import oncall.util.validator.InputValidator
import oncall.view.InputView
import oncall.view.OutputView

class OncallController {
    fun run() {
        val startDate = inputMonthAndWeekday()
        val workTurn = inputWorkTurn()
        val calendar = CalendarManager.generateCalendar(startDate)
        val schedule = ScheduleManager.generateSchedule(calendar, workTurn)
        OutputView.printSchedule(schedule)
    }

    private fun inputMonthAndWeekday(): StartDate {
        while (true) {
            try {
                val input = InputView.inputValue(InputMessage.MONTH_AND_WEEKDAY.toString())
                InputValidator.validateMonthAndWeekday(input)
                val startDate = StartDateParser.parse(input)
                return startDate
            } catch (e: IllegalArgumentException) {
                println(ErrorMessage.INVALID_FORMAT.toString())
            }
        }
    }

    private fun inputWorkTurn(): Map<WorkType, List<String>>{
        while (true) {
            try {
                val inputWeekdayTurn = InputView.inputValue(InputMessage.WEEKDAY_TURN.toString())
                InputValidator.validateWorkTurn(inputWeekdayTurn)
                val inputHolidayTurn = InputView.inputValue(InputMessage.HOLIDAY_TURN.toString())
                InputValidator.validateWorkTurn(inputHolidayTurn)
                return TurnParser.parserTurn(inputWeekdayTurn, inputHolidayTurn)
            }catch (e: IllegalArgumentException){
                println(ErrorMessage.INVALID_FORMAT.toString())
            }
        }
    }
}