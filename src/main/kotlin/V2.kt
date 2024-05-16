package io.system

import kotlin.math.sqrt

data class V2(
    val x: Float,
    val y: Float
) {

    constructor(
        x: Number = 0,
        y: Number = 0
    ) : this(
        x.toFloat(),
        y.toFloat()
    )

    operator fun plus(v: V2): V2 {
        return V2(
            x + v.x,
            y + v.y
        )
    }

    operator fun minus(v: V2): V2 {
        return V2(
            x - v.x,
            y - v.y
        )
    }

    operator fun times(n: Number): V2 {
        val f = n.toFloat()
        return V2(
            x * f,
            y * f
        )
    }

    operator fun div(n: Number): V2 {
        val f = n.toFloat()
        return V2(
            x / f,
            y / f
        )
    }

    operator fun unaryMinus(): V2 {
        return V2(-x, -y)
    }

    val length: Float
        get() {
            return sqrt(x * x + y * y)
        }

    val unit: V2
        get() {
            return this / length
        }
}
