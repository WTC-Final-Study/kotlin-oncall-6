package oncall.model

data class WorkList(
    val weekday: MutableList<String>,
    val holiday: MutableList<String>
)
