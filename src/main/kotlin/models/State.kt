package models

class State {
    private var stateValue: StateValue = StateValue.START

    fun next() {
        stateValue = StateValue.entries[stateValue.ordinal + 1]
    }

    fun getValue(): StateValue = stateValue
}
