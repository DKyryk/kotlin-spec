package com.ercarts.puzzles

import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author dkyryk
 */
class TestTaskScheduler {

    @Test
    fun tasksProcessed() {
        val solution = Solution()
        val workQueue = solution.leastInterval("AAABBB".toCharArray(), 2)
        assertEquals(8, workQueue)
    }

    @Test
    fun nonEvenlyDistributedTasksProcessed() {
        val solution = Solution()
        val workQueue = solution.leastInterval("AAAAAABCDEFG".toCharArray(), 2)
        assertEquals(16, workQueue)
    }
}