package oncall.view

import oncall.constants.OutputMsg

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

    fun displayError(message: String) {
        println(message)
    }
}
