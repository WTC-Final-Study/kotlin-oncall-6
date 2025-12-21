package oncall.constant

enum class DayOfWeek(val id: Int, val text: String) {
    MONDAY(0, "월"),
    TUESDAY(1, "화"),
    WEDNESDAY(2, "수"),
    THURSDAY(3, "목"),
    FRIDAY(4, "금"),
    SATURDAY(5, "토"),
    SUNDAY(6, "일");

    companion object {
        fun getTextById(id: Int): String {
            return when (id) {
                0 -> MONDAY.text
                1 -> TUESDAY.text
                2 -> WEDNESDAY.text
                3 -> THURSDAY.text
                4 -> FRIDAY.text
                5 -> SATURDAY.text
                6 -> SUNDAY.text
                else -> ""
            }
        }

        fun getIdByText(text: String): Int {
            return when (text) {
                MONDAY.text -> MONDAY.id
                TUESDAY.text -> TUESDAY.id
                WEDNESDAY.text -> WEDNESDAY.id
                THURSDAY.text -> THURSDAY.id
                FRIDAY.text -> FRIDAY.id
                SATURDAY.text -> SATURDAY.id
                else -> 0
            }
        }
    }
}