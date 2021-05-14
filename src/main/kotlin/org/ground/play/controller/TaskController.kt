package org.ground.play.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.annotation.Post
import org.ground.play.common.exception.TaskException
import org.ground.play.model.Task
import org.ground.play.service.TaskService
import javax.inject.Inject

@Controller("/task")
class TaskController() {

    @Inject
    lateinit var taskService: TaskService

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

    @Get("/{name}")
    fun tryTask(name: String): HttpResponse<String> {
        return if (name == "moto") {
            HttpResponse.ok("good")
        } else HttpResponse.badRequest()
    }

    @Delete("/{taskId}")
    fun deleteTask(taskId: Long): HttpResponse<Any> {
        return try {
            HttpResponse.ok(taskService.deleteTask(taskId))
        } catch (te: TaskException) {
            HttpResponse.badRequest(te)
        }
    }

}