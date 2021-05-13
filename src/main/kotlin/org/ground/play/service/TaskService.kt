package org.ground.play.service

import org.ground.play.model.Task
import javax.inject.Singleton

@Singleton
class TaskService {
    private val tasks = MutableList(5) { Task("Task $it", it+1) }

    fun getTasks(): List<Task> {
        return tasks
    }

    fun createTask(task: Task): Task {
        tasks.add(task)
        return task
    }
}