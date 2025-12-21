package oncall.message

enum class InputMessage(val text: String) {
    START_INFO("비상 근무를 배정할 월과 시작 요일을 입력하세요>"),
    WEEKDAY_LIST("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),
    HOLIDAY_LIST("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");

    override fun toString(): String {
        return text
    }
}