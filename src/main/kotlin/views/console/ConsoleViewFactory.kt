package views.console

import views.ViewFactory
import views.console.utils.ErrorMessage

class ConsoleViewFactory: ViewFactory {
    override fun createBoardView(): BoardView = BoardView()
    override fun createPlayerView(): PlayerView = PlayerView()
    override fun createResumeView(): ResumeView = ResumeView()
    override fun createPlayView(): PlayView = PlayView()
    override fun createMenuView(): MenuView = MenuView()
    override fun createStartView(): StartView = StartView()
    override fun createErrorView(error: ErrorMessage): ErrorView = ErrorView(error)
}
