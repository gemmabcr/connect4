package views.console

import org.junit.jupiter.api.Test
import views.console.utils.ErrorMessage
import kotlin.test.assertEquals

class ErrorViewTest {
    private val message: ErrorMessage = ErrorMessage.NONEXISTENT_COLUMN
    private val errorView: ErrorView = ErrorView(message)

    @Test
    fun `given message to error view when call message then print message in console`() {
        assertEquals(errorView.message(), println("** ${message.message} **"))
    }
}