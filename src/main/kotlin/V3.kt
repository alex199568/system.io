package io.system

import kotlin.math.sqrt

data class V3(
    val x: Float,
    val y: Float,
    val z: Float
) {

    constructor(
        x: Number = 0,
        y: Number = 0,
        z: Number = 0
    ) : this(
        x.toFloat(),
        y.toFloat(),
        z.toFloat()
    )

    operator fun plus(v: V3): V3 {
        return V3(
            x + v.x,
            y + v.y,
            z + v.z
        )
    }

    operator fun minus(v: V3): V3 {
        return V3(
            x - v.x,
            y - v.y,
            z - v.z
        )
    }

    operator fun times(n: Number): V3 {
        val f = n.toFloat()
        return V3(
            x * f,
            y * f,
            z * f
        )
    }

    operator fun div(n: Number): V3 {
        val f = n.toFloat()
        return V3(
            x / f,
            y / f,
            z / f
        )
    }

    operator fun unaryMinus(): V3 {
        return V3(-x, -y, -z)
    }

    val length: Float
        get() {
            return sqrt(x * x + y * y + z * z)
        }

    val unit: V3
        get() {
            return this / length
        }
}
