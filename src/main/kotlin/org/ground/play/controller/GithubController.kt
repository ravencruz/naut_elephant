package org.ground.play.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import io.reactivex.Maybe
import org.ground.play.beans.GithubRelease
import org.ground.play.common.route.GithubApiClient
import org.ground.play.common.route.GithubLowLevelClient

@Controller("/github")
class GithubController (private val githubLowLevelClient: GithubLowLevelClient,
                        private val githubApiClient: GithubApiClient) {

    @Get("/releases-low-level")
    fun releases(): Maybe<List<GithubRelease>> {
        return githubLowLevelClient.fetchReleases()
    }

    @Get(uri = "/releases", produces = [MediaType.APPLICATION_JSON_STREAM])
    fun fetchReleases(): Flowable<GithubRelease?>? {
        return githubApiClient.fetchReleases()
    }
}