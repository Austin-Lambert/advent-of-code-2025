package dev.lambo.days.one

enum class Direction(val abbr: Char) {
    LEFT('L'),
    RIGHT('R');

    companion object {
        fun fromAbbr(abbr: Char): Direction {
            return Direction.entries.first { it.abbr == abbr }
        }
    }
}