package oncall.message

enum class ErrorMessage(val text: String) {
    INVALID_FORMAT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    override fun toString(): String {
        return "[ERROR] $text"
    }
}