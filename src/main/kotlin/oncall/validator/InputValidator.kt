package oncall.validator

import oncall.message.ErrorMessage

object InputValidator {

    val weekdayKR = setOf("일", "월", "화", "수", "목", "금", "토")

    fun validateMonthAndWeekday(monthAndWeekday: String) {
        require(monthAndWeekday.contains(",")) { ErrorMessage.INVALID_FORMAT.toString() }
        val monthAndWeekday = monthAndWeekday.split(",")
        val month = monthAndWeekday.first().toIntOrNull()
        val weekday = monthAndWeekday.last()

        require(month != null) { ErrorMessage.INVALID_FORMAT.toString() }
        require(month in 1..12) { ErrorMessage.INVALID_FORMAT.toString() }
        require(weekdayKR.contains(weekday)) { ErrorMessage.INVALID_FORMAT.toString() }
    }
}