package oncall.model

import java.time.DayOfWeek


data class StartDate(
    val month: Int,
    val dayOfWeek: DayOfWeek
)
