package models

class Registry(private val game: Game) {
    private val mementos: MutableList<Memento> = mutableListOf()
    private var firstPrevious: Int = 0

    init {
        mementos.add(game.createMemento())
    }

    fun register() {
        for (i in 0..< firstPrevious) {
            mementos.removeAt(0)
        }
        firstPrevious = 0
        mementos.add(firstPrevious, game.createMemento())
    }

    fun undo() {
        assert(undoable())
        firstPrevious++
        game.setMemento(mementos[firstPrevious])
    }

    fun redo() {
        assert(redoable())
        firstPrevious--
        game.setMemento(mementos[firstPrevious])
    }

    fun undoable(): Boolean {
        return firstPrevious < mementos.size - 1
    }

    fun redoable(): Boolean {
        return firstPrevious >= 1
    }
}
