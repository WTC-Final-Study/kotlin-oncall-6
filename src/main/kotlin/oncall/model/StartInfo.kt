package oncall.model

import oncall.constant.DayOfWeek

data class StartInfo(
    val month: Int,
    val dayOfWeek: DayOfWeek
)
