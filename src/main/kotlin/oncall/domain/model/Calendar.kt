package oncall.domain.model

class Calendar(
    val month: Int,
    private val startDayOfWeek: String
) {
    val startDate = Date(month, 1)
    val lengthOrMonth: Int
    private val dayOfWeek: List<String>

    init {
        lengthOrMonth = calculateLengthOrMonth()
        dayOfWeek = calculateDayOfWeek()
    }

    private fun calculateLengthOrMonth(): Int {
        return when {
            month == 2 -> 28
            month < 8 && month % 2 == 1 -> 31
            month < 8 -> 30
            month >= 8 && month % 2 == 0 -> 31
            else -> 30
        }
    }

    private fun calculateDayOfWeek(): List<String> {
        val dayOfWeekStr = listOf("일", "월", "화", "수", "목", "금", "토")

        val startIdx = dayOfWeekStr.indexOf(startDayOfWeek)
        if (startIdx < 0) throw IllegalArgumentException()

        return (0..6).map { dayOfWeekStr[(startIdx + it) % 7] }
    }

    fun dayOfWeek(date: Int): String {
        val diff = startDate.date - date
        return dayOfWeek[diff % 7]
    }

    fun onWeekend(date: Int): Boolean {
        val diff = startDate.date - date
        val dayOfWeek = dayOfWeek[diff % 7]
        return dayOfWeek == "토" || dayOfWeek == "일"
    }
}
