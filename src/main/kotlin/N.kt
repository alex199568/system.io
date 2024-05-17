package io.system

val Float.decimalPlaces: Int
    get() {
        var count = 0
        var value = this
        while (value % 1 != 0f) {
            value *= 10
            count++
        }
        return count
    }

val Double.decimalPlaces: Int
    get() {
        var count = 0
        var value = this
        while (value % 1 != 0.0) {
            value *= 10
            count++
        }
        return count
    }