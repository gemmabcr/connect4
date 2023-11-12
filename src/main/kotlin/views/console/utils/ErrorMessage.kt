package views.console.utils

enum class ErrorMessage(val message: String) {
    PLENTY_COLUMN("This column is plenty, you can't put your token here"),
    NONEXISTENT_COLUMN("This column does not exist"),
    NOT_UNDOABLE("Can not undo a previous action"),
    NOT_REDOABLE("Can not redo a previous action"),
}
