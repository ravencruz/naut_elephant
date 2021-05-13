package org.ground.play.service

import org.ground.play.model.Task
import javax.inject.Singleton

@Singleton
class TaskService {
    private val tasks = List(10) { Task("Task $it", 1) }

    fun getAll(): List<Task> {
        return tasks
    }
}