package org.ground.play.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.annotation.Post
import org.ground.play.model.Task
import org.ground.play.service.TaskService

@Controller("/task")
class TaskController(private val taskService: TaskService) {

    @Get
    fun getAll(): List<Task> {
        return taskService.getTasks()
    }

    @Post
    fun createTask(task: Task): Task {
        return taskService.createTask(task)
    }

    @Patch
    fun updateTask(task: Task): Task? {
        return taskService.updateTask(task)
    }

    @Delete("/{taskId}")
    fun deleteTask(taskId: Long): Task {
        return taskService.deleteTask(taskId)
    }

    @Get("/{name}")
    fun tryTask(name: String): HttpResponse<String> {
        return if (name == "moto") {
            HttpResponse.ok("good")
        } else HttpResponse.badRequest()
    }

}