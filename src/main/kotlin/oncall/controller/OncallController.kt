package oncall.controller

import oncall.message.InputMessage
import oncall.view.InputView

class OncallController {
    fun run() {
        inputMonthAndWeekday()
    }

    private fun inputMonthAndWeekday() {
        val input = InputView.inputValue(InputMessage.MONTH_AND_WEEKDAY.toString())
    }
}