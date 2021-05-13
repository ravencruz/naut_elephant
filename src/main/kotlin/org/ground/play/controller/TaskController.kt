package org.ground.play.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.ground.play.model.Task
import org.ground.play.service.TaskService
import javax.inject.Inject

@Controller("/task")
class TaskController() {

    @Inject
    lateinit var taskService: TaskService

    @Get("/")
    fun getAll(): List<Task> {
        return taskService.getTasks()
    }

    @Post
    fun createTask(task: Task): Task {
        return taskService.createTask(task)
    }

}