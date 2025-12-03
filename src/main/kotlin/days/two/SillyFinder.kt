package dev.lambo.days.two

class SillyFinder {
    fun findSingleRepeatSequences(range: String): List<String> {
        val (start, end) = parseRange(range)
        return start.until(end + 1).mapNotNull {
            val str = it.toString()
            if (str.length % 2 != 0) return@mapNotNull null
            findRepeats(str, str.length / 2)
        }
    }

    fun findDeepRepeatSequences(range: String): List<String> {
        val (start, end) = parseRange(range)
        return start.until(end + 1).flatMap { outer ->
            val str = outer.toString()
            val maxDiv = str.length / 2
            1.until(maxDiv + 1).mapNotNull { inner ->
                findRepeats(str, inner)
            }
        }
    }

    private fun parseRange(range: String): Pair<Long, Long> {
        val (start, end) = range.split("-").map { it.toLong() }
        return start to end
    }

    private fun findRepeats(str: String, div: Int): String? {
        if (str.length % div != 0) return null
        val portions = str.chunked(div).toSet()
        if (portions.size == 1) return str
        return null
    }
}
