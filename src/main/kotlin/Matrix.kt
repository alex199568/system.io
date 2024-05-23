package io.system

import io.system.num.Rational

class Matrix() {

    private val rows = mutableListOf<MutableList<Rational>>()

    constructor(vararg rows: List<Rational>) : this() {
        rows.forEach { row ->
            this.rows += row.toMutableList()
        }
    }

    operator fun get(i: Int, j: Int): Rational {
        if (i >= rows.size) return Rational(0)
        val row = rows[i]
        if (j >= row.size) return Rational(0)
        return row[j]
    }

    override fun toString(): String {
        val longestRowLength = rows.maxOf { it.size }
        val sb = StringBuilder()
        rows.forEachIndexed { i, row ->
            sb.append("| ")
            (0 until longestRowLength).forEach { j ->
                sb.append(this[i, j])
                sb.append(" ")
            }
            sb.append("|")
            sb.append("\n")
        }
        return sb.toString()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val m = Matrix(
                listOf(Rational(1), Rational(2), Rational(1)),
                listOf(Rational(0), Rational(3)),
                listOf(Rational(4))
            )
            println(m)
        }
    }
}
