package models

enum class StateValue {
    START, IN_GAME, RESUME, EXIT;

    companion object {
        fun next(stateValue: StateValue): StateValue {
            if (stateValue !== EXIT) {
                return entries[stateValue.ordinal + 1]
            }
            return EXIT
        }
    }
}
