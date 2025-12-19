package oncall.model

import java.time.DayOfWeek

data class Day(
    val month: Int,
    val day: Int,
    val dayOfWeek: DayOfWeek,
    val isHoliday: Boolean,
    var worker: String = ""
)
