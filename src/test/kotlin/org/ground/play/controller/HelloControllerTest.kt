package org.ground.play.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class HelloControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun index() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
        Assertions.assertEquals("Hello World", body)
    }
}