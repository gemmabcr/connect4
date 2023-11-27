package controllers.controller

import controllers.Controller
import models.Session

class ControllerForTesting(session: Session): Controller(session) {
    override fun execute() {}
}