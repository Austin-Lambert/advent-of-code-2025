package dev.lambo.days.one

class Dial(private val initial: Int = 0) {
    var setting: Int = initial
        private set

    var setToZero: Int = 0
        private set

    var passedZero: Int = 0
        private set

    fun turn(direction: Direction, amount: Int) {
        0.until(amount).map {
            tick(direction)
        }
        if(setting == 0) setToZero++
    }

    private fun tick(direction: Direction) {
        when (direction) {
            Direction.LEFT -> {
                if (setting == 0) setting = 99
                else setting--
            }
            Direction.RIGHT -> {
                if(setting == 99) setting = 0
                else setting++
            }
        }
        if (setting == 0) passedZero++
    }

    fun reset() {
        setting = initial.mod(100)
        setToZero = 0
        passedZero = 0
    }

    override fun toString(): String {
        return "Dial(setting=$setting, setToZero=$setToZero, passedZero=$passedZero)"
    }
}