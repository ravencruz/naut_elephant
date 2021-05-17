package org.ground.play.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe
import org.ground.play.beans.GithubRelease
import org.ground.play.common.route.GithubLowLevelClient

@Controller("/github")
class GithubController (private val githubLowLevelClient: GithubLowLevelClient) {

    @Get("/releases-low-level")
    fun releases(): Maybe<List<GithubRelease>> {
        return githubLowLevelClient.fetchReleases()
    }

}