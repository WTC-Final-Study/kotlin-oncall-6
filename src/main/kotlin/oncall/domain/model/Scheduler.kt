package oncall.domain.model

class Scheduler(
    val calendar: Calendar,
    private val weekdayOrder: List<String>,
    private val weekendOrder: List<String>
) {
    private val weekdayQue = createQue(weekdayOrder)
    private val weekendQue = createQue(weekendOrder)

    private val schedule = mutableListOf<DaySchedule>()

    fun createSchedule(): List<DaySchedule> {
        (1..calendar.lengthOrMonth).forEach { date ->
            if (isHoliday(date)) addWeekend(date)
            else addWeekday(date)
        }
        return schedule
    }


    private fun addWeekend(date: Int) {
        if (canAssign(weekendQue.first())) {
            add(date, weekendQue.removeFirst())
        } else {
            val temp = weekendQue.removeFirst()
            add(date, weekendQue.removeFirst())
            weekendQue.addFirst(temp)
        }
    }

    private fun addWeekday(date: Int) {
        if (canAssign(weekdayQue.first())) {
            add(date, weekdayQue.removeFirst())
        } else {
            val temp = weekdayQue.removeFirst()
            add(date, weekdayQue.removeFirst())
            weekdayQue.addFirst(temp)
        }
    }

    private fun add(date: Int, name: String) {
        schedule.add(
            DaySchedule(
                month = calendar.month,
                date = date,
                dayOfWeek = calendar.dayOfWeek(date),
                name = name
            )
        )
    }

    private fun createQue(order: List<String>): ArrayDeque<String> {
        val que = ArrayDeque<String>()
        val times = calendar.lengthOrMonth / order.size + 1
        repeat(times) {
            que.addAll(order)
        }
        return que
    }

    fun canAssign(name: String): Boolean {
        return schedule.isEmpty() || schedule.last().name != name
    }

    private fun isHoliday(date: Int): Boolean {
        return calendar.onWeekend(date) || PublicHoliday.onHoliday(calendar.month, date)
    }
}
