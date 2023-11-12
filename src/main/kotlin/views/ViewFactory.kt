package views

import views.console.*
import views.console.utils.ErrorMessage

interface ViewFactory {
    fun createBoardView(): BoardView
    fun createPlayerView(): PlayerView
    fun createResumeView(): ResumeView
    fun createPlayView(): PlayView
    fun createMenuView(): MenuView
    fun createStartView(): StartView
    fun createErrorView(error: ErrorMessage): ErrorView
}
