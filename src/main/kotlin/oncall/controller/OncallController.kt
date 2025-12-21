package oncall.controller

import oncall.message.InputMessage
import oncall.model.StartInfo
import oncall.service.StartInfoConverter
import oncall.util.InputValidator
import oncall.view.InputView

class OncallController {

    fun run() {
        val startInfo = inputStartInfo()
    }

    private fun inputStartInfo(): StartInfo {
        while (true) {
            try {
                val input = InputView.input(InputMessage.START_INFO.toString())
                InputValidator.validateStartInfo(input)
                return startInfoConversion(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun startInfoConversion(input: String): StartInfo {
        return StartInfoConverter.convert(input)
    }
}