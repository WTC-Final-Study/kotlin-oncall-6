package oncall.service

import oncall.model.StartInfo
import oncall.model.WorkList
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ScheduleManagerTest {

    @Test
    fun `스케줄 생성`() {
        assertDoesNotThrow {
            val startInfo = StartInfo(
                month = 5,
                dayOfWeek = 0
            )

            CalendarManager.generateCalendar(startInfo)
            val calendar = CalendarManager.getCalendar()
            val workList = WorkList(
                "준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리".split(",").toMutableList(),
                "수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니".split(",").toMutableList()
            )
            ScheduleManager.generateSchedule(calendar, workList)
            println(ScheduleManager.getSchedule().forEach { key, value ->
                println("$key -> $value")
            })
        }
    }
}