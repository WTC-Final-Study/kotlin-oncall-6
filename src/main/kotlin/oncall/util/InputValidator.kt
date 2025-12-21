package oncall.util

import oncall.constant.DayOfWeek
import oncall.constant.message.ErrorMessage

object InputValidator {

    fun validateStartInfo(input: String) {
        require(input.contains(",")) { ErrorMessage.INVALID_FORMAT.toString() }
        val (month, startWeekday) = input.split(",")
        require(month.toIntOrNull() != null) { ErrorMessage.INVALID_FORMAT.toString() }
        require(month.toInt() in 1..12) { ErrorMessage.INVALID_FORMAT.toString() }
        require(DayOfWeek.getDayOfWeekByText(startWeekday) != null) { ErrorMessage.INVALID_FORMAT.toString() }
    }

    fun validateWorkList(input: String) {
        val splitInput = input.split(",")
        require(splitInput.size in 5..35) { ErrorMessage.INVALID_FORMAT.toString() }
        require(splitInput.size == splitInput.toSet().size) { ErrorMessage.INVALID_FORMAT.toString() }
        require(splitInput.all { it.length in 1..5 }) { ErrorMessage.INVALID_FORMAT.toString() }
    }
}