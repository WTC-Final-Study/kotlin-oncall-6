package oncall.validator

import oncall.message.ErrorMessage

object InputValidator {

    val weekdayKR = setOf("일", "월", "화", "수", "목", "금", "토")

    fun validateMonthAndWeekday(monthAndWeekday: String) {
        require(monthAndWeekday.contains(",")) { ErrorMessage.INVALID_FORMAT.toString() }
        val monthAndWeekday = monthAndWeekday.split(",")
        val month = monthAndWeekday.first().toIntOrNull()
        val weekday = monthAndWeekday.last()

        require(month != null)
        require(month in 1..12)
        require(weekdayKR.contains(weekday))
    }

    fun validateWorkTurn(workTurn: String) {
        require(workTurn.contains(","))
        val workTurn = workTurn.split(",")
        require(workTurn.size in 5..35)
        require(workTurn.size == workTurn.toSet().size)
        workTurn.forEach { turn ->
            require(turn.length in 1..5)
        }
    }
}