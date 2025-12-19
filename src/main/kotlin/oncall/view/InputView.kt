package oncall.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun inputValue(text: String): String {
        print(text)
        return Console.readLine()
    }
}