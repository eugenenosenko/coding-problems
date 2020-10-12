package com.eugenenosenko.coding.problems.arrays.compose_from_old


fun createArray(arr: IntArray): IntArray {
    val result = mutableListOf<Int>()
    for (i in arr.indices) {
        result.add(
            arr.foldIndexed(1) { index: Int, acc: Int, item: Int ->
                if (i == index) acc else acc * item
            }
        )
    }
    return result.toIntArray()
}

// more efficient but doesn't care about
fun createArrayMoreEfficient(arr: IntArray): IntArray {
    val result = mutableListOf<Int>()
    arr.sort()

    val first = arr.reduce { acc, i -> acc * i }
    result.add(first)

    for (i in 1 until arr.size) {
        result.add((first / arr[i]))
    }

    return result.toIntArray()
}

fun main() {
    val intArrayOf = intArrayOf(3, 2, 1)
    val createArrayMoreEfficient = createArrayMoreEfficient(intArrayOf)
    println("intArrayOf.toList() = ${createArrayMoreEfficient.toList()}")
}