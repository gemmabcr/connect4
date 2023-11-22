package controllers.play

interface AcceptorPlayController {
    fun accept(playerControllerVisitor: PlayVisitor)
}
