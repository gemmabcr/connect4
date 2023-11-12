package models.board

enum class Column {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

    fun leftColumns(): List<Column> {
        val list: MutableList<Column> = mutableListOf()
        var i = this.ordinal
        while (i >= ONE.ordinal) {
            if (i != this.ordinal) {
                list.add(entries[i])
            }
            i--
        }
        return list.toList()
    }

    fun rightColumns(): List<Column> {
        val list: MutableList<Column> = mutableListOf()
        var i = this.ordinal
        while (i <= SEVEN.ordinal) {
            if (i != this.ordinal) {
                list.add(entries[i])
            }
            i++
        }
        return list.toList()
    }

    companion object {
        fun build(index: Int): Column {
            assert(index in 1..7)
            return when (index) {
                1 -> ONE
                2 -> TWO
                3 -> THREE
                4 -> FOUR
                5 -> FIVE
                6 -> SIX
                7 -> SEVEN
                else -> throw Exception("This column does not exist")
            }
        }
    }
}
