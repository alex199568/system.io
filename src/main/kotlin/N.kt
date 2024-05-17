package io.system

import java.math.BigInteger



fun Double.toBigInt(): BigInteger {
    return toLong().toBigInteger()
}
