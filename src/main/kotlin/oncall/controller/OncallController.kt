package oncall.controller

import oncall.message.ErrorMessage
import oncall.message.InputMessage
import oncall.validator.InputValidator
import oncall.view.InputView

class OncallController {
    fun run() {
        inputMonthAndWeekday()
    }

    private fun inputMonthAndWeekday() {
        while (true) {
            try{
                val input = InputView.inputValue(InputMessage.MONTH_AND_WEEKDAY.toString())
                InputValidator.validateMonthAndWeekday(input)
                break
            }catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}