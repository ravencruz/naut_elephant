package org.ground.play.common.exception

import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import javax.inject.Singleton

@Produces
@Singleton
@Requirements(
    Requires(classes = [TaskException::class, ExceptionHandler::class])
)
class TaskExceptionHandler
    (private val errorResponseProcessor: ErrorResponseProcessor<Any>)
    : ExceptionHandler<TaskException, HttpResponse<*>>
{

    override fun handle(request: HttpRequest<*>, exception: TaskException): HttpResponse<*> {
        return errorResponseProcessor.processResponse(
            ErrorContext.builder(request)
                .cause(exception)
                .errorMessage(exception.message)
                .build(), HttpResponse.badRequest<Any>())
    }
}