package oncall.controller

import oncall.constants.ErrorType

object InputParser {
    private val dayOfWeek = listOf("일", "월", "화", "수", "목", "금", "토")

    fun parseDay(input: String): Pair<Int, String> {
        require(input.isNotBlank()) { ErrorType.INVALID_FORMAT }
        require(input.contains(",")) { ErrorType.INVALID_FORMAT }
        val (monthStr, dayOfWeekStr) = input.split(",").map { it.trim() }

        val month = requireNotNull(monthStr.toIntOrNull()) { ErrorType.INVALID_FORMAT }
        require(month in 1..12) { ErrorType.INVALID_FORMAT }
        require(dayOfWeek.contains(dayOfWeekStr)) { ErrorType.INVALID_FORMAT }

        return month to dayOfWeekStr
    }

    fun parseName(input: String): List<String> {
        require(input.isNotBlank()) { ErrorType.INVALID_FORMAT }
        val names = input.split(",").map { it.trim() }

        require(names.all { it.length <= 5 }) { ErrorType.INVALID_FORMAT }
        require(names.size in 5..35) { ErrorType.INVALID_FORMAT }

        require(names.size == names.distinct().size) { ErrorType.INVALID_FORMAT }
        return names
    }
}
