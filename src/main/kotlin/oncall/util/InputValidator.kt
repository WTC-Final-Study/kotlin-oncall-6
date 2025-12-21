package oncall.util

import oncall.message.ErrorMessage

object InputValidator {

    fun validateStartInfo(input: String) {
        val weekdayKr = listOf("일", "월", "화", "수", "목", "금", "토")
        require(input.contains(",")) { ErrorMessage.INVALID_FORMAT.toString() }
        val (month, startWeekday) = input.split(",")
        require(month.toIntOrNull() != null) { ErrorMessage.INVALID_FORMAT.toString() }
        require(month.toInt() in 1..12) { ErrorMessage.INVALID_FORMAT.toString() }
        require(weekdayKr.contains(startWeekday)) { ErrorMessage.INVALID_FORMAT.toString() }
    }
}