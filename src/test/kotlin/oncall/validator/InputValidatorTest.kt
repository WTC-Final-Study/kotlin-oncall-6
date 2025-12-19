package oncall.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun `닉네임이 5글자 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "수아,글로고니도밥,고니,도밥,준팍"
            InputValidator.validateWorkTurn(input)
        }
    }

    @Test
    fun `중복된 닉네임을 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "수아,수아,글로,고니,도밥,준팍"
            InputValidator.validateWorkTurn(input)
        }
    }

    @Test
    fun `5명 미만으로 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "수아,글로,도밥,준팍"
            InputValidator.validateWorkTurn(input)
        }
    }

    @Test
    fun `정상 입력 시 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            val input = "수아,글로,도밥,준팍,고니"
            InputValidator.validateWorkTurn(input)
        }
    }
}