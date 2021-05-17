package org.ground.play.common.route

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import org.ground.play.beans.CryptoPrice


@Client("https://cex.io")
interface CEXClient {

    @Get("/api/last_price/{virtualCoin}/USD")
    fun getLastPrice(virtualCoin: String): Flowable<CryptoPrice?>?

}