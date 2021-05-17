package org.ground.play.common.route

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import org.ground.play.beans.GithubRelease
import org.ground.play.common.configuration.GithubConfiguration

@Client(GithubConfiguration.GITHUB_API_URL)
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json"),
)
interface GithubApiClient {

    @Get("/repos/\${github.organization}/\${github.repo}/releases")
    fun fetchReleases(): Flowable<GithubRelease?>?
}