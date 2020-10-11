package com.eugenenosenko.coding.problems.arrays.pair_with_sum_x

fun findPairSolution(arr: IntArray, sum: Int): IntArray {
    // sort array first from smallest to largest
    // you'll end up with an array [0,1,2,3,5,6]
    arr.sort()

    // create two pointers
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val rightV = arr[right]
        val leftV = arr[left]

        when {
            // for example,  sum is 7, result should be 1, 6
            // upon first iteration you'll compare numbers 0, 6
            // this will land you on the second case and increment left counter by one
            // next iteration will be between 1 and 6 which is what we're looking for

            // right value is too large
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