import views.console.ConsoleViewFactory

class ConsoleConnect4: Connect4() {
    override fun createViewFactory(): ConsoleViewFactory = ConsoleViewFactory()
}
