package io.system

fun main() {
    val v1 = V(1, 2)
    val v2 = V(2, 3)
    val v3 = V(3, 4)

    val s = Stack<V>()
    println(s)
    s.push(v1)
    println(s)
    s.push(v2)
    println(s)
    s.push(v3)
    println(s)

    while (s.isNotEmpty) {
        println(s.pop())
        println(s)
    }
}
