package oncall.controller

import oncall.message.ErrorMessage
import oncall.message.InputMessage
import oncall.model.StartDate
import oncall.service.StartDateParser
import oncall.validator.InputValidator
import oncall.view.InputView

class OncallController {
    fun run() {
        val startDate = inputMonthAndWeekday()
    }

    private fun inputMonthAndWeekday(): StartDate {
        while (true) {
            try {
                val input = InputView.inputValue(InputMessage.MONTH_AND_WEEKDAY.toString())
                InputValidator.validateMonthAndWeekday(input)
                val startDate = StartDateParser.parse(input)
                return startDate
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}