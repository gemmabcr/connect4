package models.board

enum class Row {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH;

    fun upRows(): List<Row> {
        val list: MutableList<Row> = mutableListOf()
        var i = this.ordinal
        while (i <= SIXTH.ordinal) {
            if (i != this.ordinal) {
                list.add(Row.entries[i])
            }
            i++
        }
        return list.toList()
    }

    fun downRows(): List<Row> {
        val list: MutableList<Row> = mutableListOf()
        var i = this.ordinal
        while (i >= FIRST.ordinal) {
            if (i != this.ordinal) {
                list.add(Row.entries[i])
            }
            i--
        }
        return list.toList()
    }

    companion object {
        fun last(): Row {
            return SIXTH
        }
    }
}
