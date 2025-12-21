package oncall.constants

enum class OutputMsg(val text: String) {
    WORK_DAY_PROMPT("비상 근무를 배정할 월과 시작 요일을 입력하세요>"),
    WEEKDAY_WORK_PROMPT("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),
    WEEKEND_WORK_PROMPT("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),

    DEFAULT_SCHEDULE("%d월 %d일 %s %s"),
    HOLIDAY_SCHEDULE("%d월 %d일 %s(휴일) %s");

    override fun toString(): String {
        return text
    }

    fun format(vararg args: Any): String {
        return text.format(*args)
    }
}
