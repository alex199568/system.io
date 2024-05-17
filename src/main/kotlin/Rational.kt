package io.system

import kotlin.math.abs

data class Rational(
    private var nominator: Long,
    private var denominator: Long
) {

    constructor(
        nominator: Number = 0,
        denominator: Number = 1
    ) : this(
        nominator.toLong(),
        denominator.toLong()
    )

    init {
        require(denominator != 0L)
        val gcd = gcd(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    override fun toString(): String {
        val whole = nominator / denominator
        if (whole == 0L) return "$nominator/$denominator"
        val part = nominator - whole * denominator
        if (nominator > 0L) return "$whole $part/$denominator"
        return "-(${abs(whole)} ${abs(part)}/$denominator)"
    }

    companion object {

        private fun gcd(n: Long, d: Long): Long {
            val absN = abs(n)
            val absD = abs(d)
            if (d == 0L) return absN
            return gcd(absD, absN % absD)
        }
    }
}
