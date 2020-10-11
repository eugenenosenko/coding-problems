package com.eugenenosenko.coding.problems.arrays.pair_with_sum_x

fun findPairSolution(arr: IntArray, sum: Int): IntArray {
    // sort array first
    arr.sort()

    // create two pointers
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val rightV = arr[right]
        val leftV = arr[left]

        when {
            // right value is too much
            leftV + rightV > sum -> right--
            // left value is too small
            leftV + rightV < sum -> left++
            // just right!
            leftV + rightV == sum -> return intArrayOf(leftV, rightV)
        }
    }
    return intArrayOf()
}

fun findPairOnceSolution(arr: IntArray, sum: Int): IntArray {
    val visited = HashSet<Int>()

    for (v in arr) {
        // calculate different, i.e. 17 - 7 = 10
        val tmp = sum - v

        if (visited.contains(tmp)) {
            return intArrayOf(tmp, v)
        }
        visited.add(v)
    }

    return intArrayOf()
}