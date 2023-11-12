package controllers

import models.Session

abstract class Controller(val session: Session) {
    abstract fun execute()
    fun nextState() {
        this.session.nextState()
    }
}
