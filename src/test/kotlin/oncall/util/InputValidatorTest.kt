package oncall.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `월, 시작요일 형식이 올바르지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>{
            val input = "5화"
            InputValidator.validateStartInfo(input)
        }
    }

    @Test
    fun `1~12 월 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>{
            val input = "13,월"
            InputValidator.validateStartInfo(input)
        }
    }

    @Test
    fun `요일이 월~일이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "6,소"
            InputValidator.validateStartInfo(input)
        }
    }

    @Test
    fun `올바르게 입력하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            val input = "12,일"
            InputValidator.validateStartInfo(input)
        }
    }
}