package io.system

data class Rational(
    val nominator: Long,
    val denominator: Long
) {

    constructor(
        nominator: Number = 0,
        denominator: Number = 1
    ) : this(
        nominator.toLong(),
        denominator.toLong()
    )

    override fun toString(): String {
        return "$nominator/$denominator"
    }
}
