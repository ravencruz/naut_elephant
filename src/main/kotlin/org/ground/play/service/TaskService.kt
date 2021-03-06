package org.ground.play.service

import io.micronaut.http.HttpStatus
import org.ground.play.common.exception.ErrorMessage
import org.ground.play.common.exception.TaskException
import org.ground.play.model.Task
import javax.inject.Singleton

@Singleton
class TaskService {
    private val tasks = MutableList(4) {
        Task(it+1L, "Task $it", it+1)
    }

    fun getTasks(): List<Task> {
        return tasks
    }

    fun createTask(task: Task): Task {
        task.id = tasks[tasks.lastIndex].id?.plus(1L)
        tasks.add(task)
        return task
    }

    fun updateTask(task: Task): Task? {
        return tasks
            .find { it.id == task.id }
            ?.apply {
                name = task.name
                completed = task.completed
                hours = task.hours
            }
    }

    fun deleteTask(id: Long): Task {
        return tasks.find { it.id == id }
            ?.also {
                tasks.remove(it)
            }
            ?: throw TaskException(HttpStatus.BAD_REQUEST, ErrorMessage.USER_NOT_FOUND)
    }
}