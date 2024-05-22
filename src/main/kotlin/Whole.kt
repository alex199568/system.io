package io.system

import java.math.BigInteger

class Whole(

) {

    private var value: BigInteger = BigInteger.ZERO

    constructor(i: Int) : this() {
        require(i >= 0)
        value = BigInteger.valueOf(i.toLong())
    }

    constructor(l: Long) : this() {
        require(l >= 0L)
        value = BigInteger.valueOf(l)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val w = Whole(3)
            println(w)
        }
    }
}
