package com.eugenenosenko.coding.problems.arrays.compose_from_old

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test

private fun createNewArray(arr: IntArray): IntArray {
    TODO("Implement me!")
}


class ComposeArrayFromOldTest {

    @Test
    fun `should return correct array of {120, 60, 40, 30, 24} for {1, 2, 3, 4, 5}`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val result = createNewArray(arr)

        assertThat(result, `is`(intArrayOf(120, 60, 40, 30, 24)))
    }
}