package oncall.domain.model

data class DaySchedule(
    val month: Int,
    val date: Int,
    val dayOfWeek: String,
    val name: String,
) {
    val isWeekday get() = dayOfWeek != "토" && dayOfWeek != "일"

    val isPublicHoliday get() = PublicHoliday.onHoliday(month, date)
}
