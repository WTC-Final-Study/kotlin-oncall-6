package oncall.controller

import oncall.constants.ErrorType
import oncall.domain.model.Calendar
import oncall.domain.model.Scheduler
import oncall.view.InputView
import oncall.view.OutputView

class Controller {
    private lateinit var workService: Scheduler

    fun run() {
        val calendar = createCalendar()
        workService = Scheduler(calendar)
        val (weekdayOrder, weekendOrder) = getOrderOfWork()
        val schedule = workService.createSchedule(weekdayOrder, weekendOrder)
        OutputView.displaySchedule(schedule)
    }

    private fun createCalendar(): Calendar {
        val (month, dayOfWeek) = getWorkDay()
        return Calendar(month, dayOfWeek)
    }

    private fun getWorkDay(): Pair<Int, String> {
        retryUntilValid {
            OutputView.workDayPrompt()
            val input = InputView.read()
            return InputParser.parseDay(input)
        }
    }

    private fun getOrderOfWork(): Pair<List<String>, List<String>> {
        retryUntilValid {
            OutputView.weekdayWorkPrompt()
            val weekdayOrder = getWorkers()

            OutputView.weekendWorkPrompt()
            val weekendOrder = getWorkers()
            return weekdayOrder to weekendOrder
        }
    }

    private fun getWorkers(): List<String> {
        val input = InputView.read()
        return InputParser.parseName(input)
    }

    private inline fun <T> retryUntilValid(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                OutputView.displayError(e.message ?: ErrorType.UNKNOWN.toString())
            }
        }
    }
}
