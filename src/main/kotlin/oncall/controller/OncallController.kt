package oncall.controller

import oncall.message.InputMessage
import oncall.util.InputValidator
import oncall.view.InputView

class OncallController {

    fun run() {
        inputStartInfo()
    }

    private fun inputStartInfo() {
        while (true) {
            try {
                val input = InputView.input(InputMessage.START_INFO.toString())
                InputValidator.validateStartInfo(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}