package oncall.domain.model

class Scheduler(
    val calendar: Calendar
) {

    fun createSchedule(
        weekdayOrder: List<String>,
        weekendOrder: List<String>
    ): List<DaySchedule> {
        val schedule = arrange(weekdayOrder, weekendOrder)
        return (schedule.indices).map { idx ->
            DaySchedule(
                month = calendar.month,
                date = idx + 1,
                dayOfWeek = calendar.dayOfWeek(idx + 1),
                name = schedule[idx]
            )
        }
    }

    private fun arrange(weekdayOrder: List<String>, weekendOrder: List<String>): List<String> {
        val weekdayQue = createQue(weekdayOrder)
        val weekendQue = createQue(weekendOrder)
        val schedule = mutableListOf<String>()
        (1..calendar.lengthOrMonth).forEach { date ->
            if (isHoliday(date) && canAssign(schedule, weekendQue.first())) {
                schedule.add(weekendQue.removeFirst())
            } else if (isHoliday(date)) {
                val temp = weekendQue.removeFirst()
                schedule.add(weekendQue.removeFirst())
                weekendQue.addFirst(temp)
            } else if (canAssign(schedule, weekdayQue.first())) {
                schedule.add(weekdayQue.removeFirst())
            } else {
                val temp = weekdayQue.removeFirst()
                schedule.add(weekdayQue.removeFirst())
                weekdayQue.addFirst(temp)
            }
        }
        return schedule
    }

    private fun createQue(order: List<String>): ArrayDeque<String> {
        val que = ArrayDeque<String>()
        val times = calendar.lengthOrMonth / order.size + 1
        repeat(times) {
            que.addAll(order)
        }
        return que
    }


    fun canAssign(schedule: List<String>, name: String): Boolean {
        return schedule.isEmpty() || schedule.last() != name
    }

    private fun isHoliday(date: Int): Boolean {
        return calendar.onWeekend(date) || PublicHoliday.onHoliday(calendar.month, date)
    }
}
