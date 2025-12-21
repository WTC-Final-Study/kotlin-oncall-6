package oncall.service

import oncall.model.StartInfo

object StartInfoConverter {

    fun convert(input: String): StartInfo {
        val splitInput = input.split(",")
        val month = splitInput.first().toInt()
        val dayOfWeek = dayOfWeekToInt(splitInput.last())
        return StartInfo(
            month = month,
            dayOfWeek = dayOfWeek
        )
    }

    private fun dayOfWeekToInt(dayOfWeek: String): Int {
        return when (dayOfWeek) {
            "월" -> 0
            "화" -> 1
            "수" -> 2
            "목" -> 3
            "금" -> 4
            "토" -> 5
            "일" -> 6
            else -> 0
        }
    }
}