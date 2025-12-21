package oncall.domain.model

object Holiday {
    private val holidays = listOf(
        Date(1, 1),
        Date(3, 1),
        Date(5, 5),
        Date(6, 6),
        Date(8, 15),
        Date(10, 3),
        Date(10, 9),
        Date(12, 25)
    )

    fun onHoliday(month: Int, date: Int): Boolean {
        return holidays.find { it.equals(month, date) } != null
    }
}
