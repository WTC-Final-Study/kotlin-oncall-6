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

    @Test
    fun `근무 인원이 5명 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "가가,나나,다다"
            InputValidator.validateWorkList(input)
        }
    }

    @Test
    fun `근무 인원이 35명 초과이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "s24,0,1,2,3,4,56,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35"
            InputValidator.validateWorkList(input)
        }
    }

    @Test
    fun `중복된 인원이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "가가,나나,다다,라라,마마,마마"
            InputValidator.validateWorkList(input)
        }
    }

    @Test
    fun `닉네임이 5자 초과하는 인원이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val input = "가가,나나,다다,라라,마마마마마마"
            InputValidator.validateWorkList(input)
        }
    }

    @Test
    fun `근무 순서를 정상적으로 입력하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            val input = "가가,나나,다다,라라,마마"
            InputValidator.validateWorkList(input)
        }
    }
}