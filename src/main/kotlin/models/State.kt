package models

class State {
    private var stateValue: StateValue = StateValue.START

    fun next() {
        stateValue = StateValue.next(stateValue)
    }

    fun getValue(): StateValue = stateValue
}
