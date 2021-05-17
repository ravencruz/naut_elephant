package org.ground.play.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.reactivex.Flowable
import org.ground.play.beans.CryptoPrice
import org.ground.play.common.route.CEXClient

@Controller("/last_price")
class CoinController(private val cexClient: CEXClient) {

    @Get(uri = "/dollar/{vcoin}", produces = [MediaType.APPLICATION_JSON_STREAM])
    fun virtualCoinToDolars(vcoin: String): Flowable<CryptoPrice?>? {
        return cexClient.getLastPrice(vcoin);
    }

    @Get(uri = "/{vcurrency}")
    @Produces(MediaType.TEXT_PLAIN)
    fun mockGetPriceOf(vcurrency: String): String {
        Thread.sleep(1000)

        return when (vcurrency) {
            "BTC" -> "50127.8"
            "XRP" -> "1.32049"
            "ETH" -> "3812.74"
            "LTC" -> "1251.6"
            "BCH" -> "1.0033"
            "USDT" -> "1.0034"
            else -> "DONT KNOW"
        }
    }
}