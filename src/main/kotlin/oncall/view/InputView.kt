package oncall.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun input(text: String): String {
        print(text)
        return Console.readLine()
    }
}