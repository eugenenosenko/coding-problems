package com.eugenenosenko.coding.problems.arrays.pair_with_sum_x

import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test


private fun findPair(arr: IntArray, sum: Int): IntArray {
    TODO("implement me")
}


class FindPairWithSumXTest {

    @Test
    internal fun `should return correct 10 and 7 for an array of {10, 15, 3, 7} `() {
        val sum = 17
        val array = intArrayOf(10, 15, 3, 7)

        assertThat(findPair(array, sum).asList(), containsInAnyOrder(10, 7))
    }
}