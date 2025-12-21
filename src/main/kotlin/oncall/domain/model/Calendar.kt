package oncall.domain.model

class Calendar(
    private val month: Int,
    private val startDayOfWeek: String
) {
    private val startDate = Date(month, 1)
    private val lastDate: Date
    private val dayOfWeek: List<String>

    init {
        lastDate = calculateLastDate()
        dayOfWeek = calculateDayOfWeek()
    }

    private fun calculateLastDate(): Date {
        val date = when {
            month == 2 -> 28
            month < 8 && month % 2 == 1 -> 31
            month < 8 -> 30
            month >= 8 && month % 2 == 0 -> 31
            else -> 30
        }
        return Date(month, date)
    }

    private fun calculateDayOfWeek(): List<String> {
        val dayOfWeekStr = listOf("일", "월", "화", "수", "목", "금", "토")

        val startIdx = dayOfWeekStr.indexOf(startDayOfWeek)
        if (startIdx < 0) throw IllegalArgumentException()

        return (0..6).map { dayOfWeekStr[(startIdx + it) % 7] }
    }

    fun Date.dayOfWeek(): String {
        val diff = startDate.date - this.date
        return dayOfWeek[diff % 7]
    }

    fun Date.isWeekend(): Boolean {
        val diff = startDate.date - this.date
        val dayOfWeek = dayOfWeek[diff % 7]
        return dayOfWeek == "토" || dayOfWeek == "일"
    }
}
