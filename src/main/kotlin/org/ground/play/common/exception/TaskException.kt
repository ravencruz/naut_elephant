package org.ground.play.common.exception

import io.micronaut.http.HttpStatus
import java.lang.RuntimeException

data class TaskException(
    val status: HttpStatus,
    override val message: String,
) : RuntimeException(message)
