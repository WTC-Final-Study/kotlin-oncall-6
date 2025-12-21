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
        fun getDayOfWeekByText(text: String): DayOfWeek? {
            return when(text) {
                "월" -> MONDAY
                "화" -> TUESDAY
                "수" -> WEDNESDAY
                "목" -> THURSDAY
                "금" -> FRIDAY
                "토" -> SATURDAY
                "일" -> SUNDAY
                else -> null
            }
        }

        fun getDayOfWeekById(id: Int): DayOfWeek? {
            return when(id) {
                MONDAY.id -> MONDAY
                TUESDAY.id -> TUESDAY
                WEDNESDAY.id -> WEDNESDAY
                THURSDAY.id -> THURSDAY
                FRIDAY.id -> FRIDAY
                SATURDAY.id -> SATURDAY
                SUNDAY.id -> SUNDAY
                else -> null
            }
        }
    }
}