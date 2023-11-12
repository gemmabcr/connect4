package views.console

import views.console.utils.ErrorMessage

class ErrorView(private val error: ErrorMessage) {
    fun message() = println("** ${error.message} **")
}
