package com.eugenenosenko.coding.problems.arrays.compose_from_old


// brute force approach
fun createArray(arr: IntArray): IntArray {
    val result = mutableListOf<Int>()
    for (i in arr.indices) {
        result.add(
                arr.foldIndexed(1) { index: Int, acc: Int, item: Int ->
                    // ignore current index
                    if (i == index) acc else acc * item
                }
        )
    }
    return result.toIntArray()
}

// more efficient
fun createArrayMoreEfficientWithDivision(arr: IntArray): IntArray {
    val product = arr.reduce { acc, v -> acc * v }
    val result = IntArray(arr.size)
    for ((i, v) in arr.withIndex()) {
        result[i] = product / v
    }

    return result
}

fun createArrayMoreEfficientWithoutDivision(arr: IntArray): IntArray {
    val prefixes = arrayListOf<Int>()

    for (number in arr) {
        if (prefixes.isNotEmpty()) {
            prefixes.add(prefixes.last() * number)
        } else {
            prefixes.add(number)
        }
    }

    // peak prefixes
    println("Prefixes are $prefixes")

    val suffixes = arrayListOf<Int>()
    for (number in arr.reversed()) {
        if (suffixes.isNotEmpty()) {
            suffixes.add(suffixes.last() * number)
        } else {
            suffixes.add(number)
        }
    }

    // peak suffixes
    suffixes.reverse()
    println("Suffixes are $suffixes")

    val result = arrayListOf<Int>()
    for (i in arr.indices) {
        when (i) {
            0 -> result.add(suffixes[i + 1])
            arr.lastIndex -> result.add(prefixes[i - 1])
            else -> result.add(suffixes[i + 1] * prefixes[i - 1])
        }
    }

    return result.toIntArray()
}