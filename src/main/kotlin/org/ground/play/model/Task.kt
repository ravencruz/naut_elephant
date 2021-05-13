package org.ground.play.model

data class Task(
    var id: Long?,
    var name: String,
    var hours: Int,
    var completed: Boolean = false,
)
