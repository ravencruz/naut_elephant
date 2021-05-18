package org.ground.play.common.configuration

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter("/repos/**")
@Requires(condition = GithubFilterCondition::class)
class GithubFilter(private val configuration: GithubConfiguration): HttpClientFilter {
    override fun doFilter(request: MutableHttpRequest<*>, chain: ClientFilterChain): Publisher<out HttpResponse<*>> {
        println("seba: ${configuration.username}, ${configuration.token}")
        return chain.proceed(request.basicAuth(configuration.username, configuration.token))
    }
}