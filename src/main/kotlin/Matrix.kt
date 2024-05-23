package io.system

import io.system.num.Rational

class Matrix(
    private val n: Int,
    private val m: Int
) {

    private val elements = Array(n) {
        Array(m) {
            Rational(0)
        }
    }

    constructor(
        vararg rows: Array<Rational>
    ) : this(rows.size, rows.maxOf { it.size }) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (j < rows[i].size) {
                    this[i, j] = rows[i][j]
                }
            }
        }
    }

    operator fun get(i: Int, j: Int): Rational {
        return elements[i][j]
    }

    operator fun set(i: Int, j: Int, r: Rational) {
        elements[i][j] = r
    }

    override fun toString(): String {
        val sb = StringBuilder()

        for (i in 0 until n) {
            for (j in 0 until m) {
                val r = elements[i][j]
                sb.append(r)
                sb.append(" ")
            }
            sb.append("\n")
        }

        return sb.toString()
    }


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val m = Matrix(2, 3)
            m[0, 0] = Rational(2)
            m[1, 2] = Rational(3)
            println(m)
            val m2 = Matrix(
                arrayOf(Rational(2), Rational(0), Rational(1)),
                arrayOf(Rational(0), Rational(3))
            )
            println(m2)
        }
    }
}
