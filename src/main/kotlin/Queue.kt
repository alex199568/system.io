package io.system

class Queue<T> {

    private var start: Node<T>? = null
    private var end: Node<T>? = null

    val isEmpty: Boolean
        get() {
            return end == null
        }

    val isNotEmpty: Boolean
        get() {
            return !isEmpty
        }

    fun enqueue(item: T) {
        val node = Node(item)

        if (start == null) {
            start = node
            end = node
            return
        }

        end!!.next = node
        end = node
    }

    fun dequeue(): T {
        val item = start!!.item
        start = start!!.next
        if (start == null) {
            end = null
        }
        return item
    }

    override fun toString(): String {
        return start.toString()
    }
}
