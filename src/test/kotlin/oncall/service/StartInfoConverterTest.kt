package oncall.service

import oncall.model.StartInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StartInfoConverterTest {

    @Test
    fun `월, 요일이 정상적으로 StartInfo로 변환된다`() {
        val input = "12,화"
        val startInfo = StartInfoConverter.convert(input)
        val expected = StartInfo(
            month = 12,
            dayOfWeek = 1
        )

        assertEquals(startInfo, expected)
    }
}