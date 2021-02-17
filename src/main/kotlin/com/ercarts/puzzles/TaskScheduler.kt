package com.ercarts.puzzles

/**
 * @author dkyryk
 */
class Solution {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val workload = mutableMapOf<Char, Int>()
        tasks.forEach {
            val count = workload.getOrDefault(it, 0) + 1
            workload[it] = count
        }
        val taskCoolDowns = mutableMapOf<Char, Int>()

        var workSize = tasks.size
        var workingQueue = 0
        while (workSize > 0) {
            val task = getAvailableTask(workload, taskCoolDowns)
            reduceCoolDowns(taskCoolDowns)

            if (task != null) {
                scheduleTask(task, workload, taskCoolDowns, n)
                workSize--
            }
            workingQueue++

        }
        return workingQueue
    }

    private fun scheduleTask(
        task: Map.Entry<Char, Int>,
        workload: MutableMap<Char, Int>,
        taskCoolDowns: MutableMap<Char, Int>,
        n: Int
    ) {
        val remaining = if (task.value > 0) task.value - 1 else 0
        workload[task.key] = remaining
        taskCoolDowns[task.key] = n
    }

    private fun reduceCoolDowns(taskCoolDowns: MutableMap<Char, Int>) {
        for (pair in taskCoolDowns) {
            pair.setValue(if (pair.value > 0) pair.value - 1 else 0)
        }
    }

    private fun getAvailableTask(
        workload: MutableMap<Char, Int>,
        taskCoolDowns: MutableMap<Char, Int>
    ) = workload.asSequence()
        .filter {
            it.value > 0 && taskCoolDowns[it.key] ?: 0 == 0
        }
        .firstOrNull()

}