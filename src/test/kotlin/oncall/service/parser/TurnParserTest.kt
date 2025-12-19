package oncall.service.parser

import oncall.model.WorkType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TurnParserTest {
    @Test
    fun `평일, 주말 근무가 순서대로 저장된다`() {
        val expectMap = mapOf(
            WorkType.WEEKDAY to listOf("수아", "글로", "도밥", "준팍", "고니"),
            WorkType.HOLIDAY to listOf("가나", "다라", "마바", "사자", "아자")
        )

        val weekday = "수아,글로,도밥,준팍,고니"
        val holiday = "가나,다라,마바,사자,아자"
        val testMap = TurnParser.parserTurn(weekday, holiday)
        Assertions.assertEquals(expectMap, testMap)
    }
}