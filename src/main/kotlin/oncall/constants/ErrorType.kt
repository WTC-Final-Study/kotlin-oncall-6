package oncall.constants

enum class ErrorType(val message: String) {
    INVALID_FORMAT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),

    UNKNOWN("알수 없는 에러 입니다. 다시 입력해주세요.");

    override fun toString(): String {
        return "[ERROR] $message"
    }
}
