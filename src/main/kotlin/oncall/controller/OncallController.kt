package oncall.controller

import oncall.message.InputMessage
import oncall.view.InputView

class OncallController {

    fun run() {
        inputStartInfo()
    }

    private fun inputStartInfo() {
        val input = InputView.input(InputMessage.START_INFO.toString())
    }
}