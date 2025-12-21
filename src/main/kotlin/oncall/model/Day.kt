package oncall.model

import oncall.constant.DayOfWeek

data class Day(
    val day: Int,
    val isHoliday: Boolean,
    val dayOfWeek: DayOfWeek,
)
