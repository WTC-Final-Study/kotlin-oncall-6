package oncall.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `형식이 잘못되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "12 금"
            InputValidator.validateMonthAndWeekday(input)
        }
    }

    @Test
    fun `월이 1~12 범위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "0,월"
            InputValidator.validateMonthAndWeekday(input)
        }
    }

    @Test
    fun `요일을 일~월로 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "12,가"
            InputValidator.validateMonthAndWeekday(input)
        }
    }

    @Test
    fun `월, 요일을 제대로 입력하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            val input = "12,금"
            InputValidator.validateMonthAndWeekday(input)
        }
    }
}