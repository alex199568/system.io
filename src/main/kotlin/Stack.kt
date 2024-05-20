package io.system

class Stack<T> {

    private var top: Node<T>? = null

    fun push(item: T) {
        top = Node(item, top)
    }

    fun pop(): T {
        val item = top!!.item
        top = top!!.next
        return item
    }

    fun peek(): T {
        return top!!.item
    }

    val isEmpty: Boolean
        get() {
            return top == null
        }

    val isNotEmpty: Boolean
        get() {
            return !isEmpty
        }

    override fun toString(): String {
        return top.toString()
    }
}
