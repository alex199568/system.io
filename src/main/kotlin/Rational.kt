package io.system

import kotlin.math.abs

data class Rational(
    private var nominator: Long,
    private var denominator: Long
) {

    private var negative = false

    constructor(
        nominator: Number = 0,
        denominator: Number = 1
    ) : this(
        nominator.toLong(),
        denominator.toLong()
    )

    init {
        require(denominator != 0L)

        negative = if (nominator >= 0L && denominator >= 0L) {
            false
        } else if (nominator < 0L && denominator < 0L) {
            false
        } else {
            true
        }

        nominator = abs(nominator)
        denominator = abs(denominator)

        val gcd = gcd(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    override fun toString(): String {
        var result = ""
        val whole = nominator / denominator
        if (whole == 0L) {
            result = "$nominator/$denominator"
        } else {
            val part = nominator - whole * denominator
            result = "$whole $part/$denominator"
        }
        if (negative) return "-($result)"
        return result
    }

    companion object {

        private fun gcd(n: Long, d: Long): Long {
            if (d == 0L) return n
            return gcd(d, n % d)
        }
    }
}
