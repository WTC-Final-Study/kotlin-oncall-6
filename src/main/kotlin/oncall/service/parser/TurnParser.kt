package oncall.service.parser

import oncall.model.WorkType

object TurnParser {

    fun parserTurn(weekDayTurn: String, holidayTurn: String): Map<WorkType, List<String>> {
        val result = mutableMapOf<WorkType, List<String>>()
        val weekDayTurn = weekDayTurn.split(",")
        val holidayTurn = holidayTurn.split(",")
        result[WorkType.WEEKDAY] = weekDayTurn
        result[WorkType.HOLIDAY] = holidayTurn
        return result
    }
}