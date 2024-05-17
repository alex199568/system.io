package io.system

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
        val gcd = gcd(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    override fun toString(): String {
        val whole = nominator / denominator
        if (whole == 0L) return "$nominator/$denominator"
        val part = nominator - whole * denominator
        return "$whole $part/$denominator"
    }

    companion object {

        private fun gcd(n: Long, d: Long): Long {
            if (d == 0L) return n
            return gcd(d, n % d)
        }
    }
}
