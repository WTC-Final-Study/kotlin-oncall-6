package oncall.service

import oncall.constant.DayOfWeek
import oncall.model.StartInfo

object StartInfoConverter {

    fun convert(input: String): StartInfo {
        val splitInput = input.split(",")
        val month = splitInput.first().toInt()
        val dayOfWeek = DayOfWeek.getIdByText(splitInput.last())
        return StartInfo(
            month = month,
            dayOfWeek = dayOfWeek
        )
    }
}