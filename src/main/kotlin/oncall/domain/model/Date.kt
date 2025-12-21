package oncall.domain.model

data class Date(
    val month: Int,
    val date: Int
) {
    fun equals(month: Int, date: Int): Boolean {
        return this.month == month && this.date == date
    }
}
