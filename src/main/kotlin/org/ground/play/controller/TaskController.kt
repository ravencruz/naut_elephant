package org.ground.play.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.ground.play.model.Task
import org.ground.play.service.TaskService
import javax.inject.Inject

@Controller("/task")
class TaskController() {

    @Inject
    lateinit var taskService: TaskService

    @Get("/")
    fun getAll(): List<Task> {
        return taskService.getAll()
    }

}