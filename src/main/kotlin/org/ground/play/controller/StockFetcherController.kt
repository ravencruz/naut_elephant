package org.ground.play.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.ground.play.beans.Stock

@Controller("/stockFetcher")
class StockFetcherController {

//    @Get(uri = "/", produces = ["text/plain"])
//    fun index(): String {
//        return "Example Response"
//    }

    @Get("/price/{tickers}")
    fun getPrices(tickers: String): List<Stock> =
        tickers.split(",")
            .map(Stock::fetchPrice)
}