package oncall.service

import oncall.model.WorkList

object WorkListConverter {

    fun convert(
        weekdayList: String,
        holidayList: String
    ): WorkList {
        return WorkList(
            weekday = weekdayList.split(",")
                .map { it.trim() }.toMutableList(),
            holiday = holidayList.split(",")
                .map { it.trim() }.toMutableList()
        )
    }
}