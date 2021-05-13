package org.ground.play.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import kotlinx.coroutines.runBlocking

@Controller("/last_price")
class CoinController {

    /**
     * {"lprice":"50127.8","curr1":"BTC","curr2":"USD"}
        {"lprice":"1.32049","curr1":"XRP","curr2":"USD"}
        {"lprice":"3812.74","curr1":"ETH","curr2":"USD"}
        {"lprice":"319.344","curr1":"LTC","curr2":"USD"}
        {"lprice":"1251.6","curr1":"BCH","curr2":"USD"}
        {"lprice":"1.0033","curr1":"USDT","curr2":"USD"}
     */
    @Get(uri = "/{vcurrency}")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun getPriceOf(vcurrency: String): String {
        Thread.sleep(1000)

        //delay(1000L)
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