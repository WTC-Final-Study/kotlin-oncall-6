package oncall.service

import oncall.model.WorkList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.exp

class WorkListConverterTest {

    @Test
    fun `worklist가 정상적으로 변환된다`() {
        val weekdayList = "가가,나나,다다,라라,마마"
        val holidayList = "자자,차차,카카,타타,파파"
        val expected = WorkList(
            weekday = weekdayList.split(",").toMutableList(),
            holiday = holidayList.split(",").toMutableList()
        )

        assertEquals(expected, WorkListConverter.convert(weekdayList, holidayList))
    }
}