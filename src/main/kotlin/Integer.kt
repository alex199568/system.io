package io.system

import java.math.BigInteger

class Integer() {

    private var value: BigInteger = BigInteger.ZERO

    constructor(i: Int) : this() {
        value = BigInteger.valueOf(i.toLong())
    }

    constructor(l: Long) : this() {
        value = BigInteger.valueOf(l)
    }

    constructor(bi: BigInteger) : this() {
        value = bi
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Integer

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val i = Integer(4)
            println(i == Integer(4))
        }
    }
}
