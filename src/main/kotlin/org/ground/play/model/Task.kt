package org.ground.play.model

data class Task(
    val name: String,
    val hours: Int,
    val completed: Boolean = false,
)
