import controllers.Logic
import views.ViewFactory

abstract class Connect4 {
    private val viewFactory: ViewFactory = this.createViewFactory()
    private val logic: Logic = Logic(viewFactory)
    protected abstract fun createViewFactory(): ViewFactory

    fun start() {
        logic.execute()
    }
}
