package oncall.constant.message

enum class OutputMessage(val text: String) {
    HOLIDAY("(휴일)");

    override fun toString(): String {
        return text
    }
}