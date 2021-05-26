package org.ground.play.controller

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriTemplate
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.ground.play.beans.Stock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

//lo que hizo Venkat es crear una interfaz que simule el metodo en el controller
//retorna nada de cosas raras simplemente una lista de Stocks

//@Client("/")
//interface StockPriceClient {
//    @Get("/price/{tickers}")
//    fun getPrices(tickers: String): List<Stock>
//}

@MicronautTest
class StockFetcherControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

//    @Inject
//    lateinit var stockPriceClient: StockPriceClient

    @Test
    fun getPrices() {
        // TODO how to send parameters to url with tests?
        val tickers = "GOOG,AMZN,ORCL"
        val request = HttpRequest.GET<Any>("/stockFetcher/price/${tickers}")

        // Sometimes, receiving just the object is not enough, and you need information about the response.
        // In this case, instead of retrieve you should use the exchange method.
        val response = client.toBlocking().exchange(request, Argument.listOf(Stock::class.java))
        Assertions.assertEquals(HttpStatus.OK, response.status)

        val stocks = response.body()
        Assertions.assertEquals(3, stocks.size)
        Assertions.assertEquals("GOOG", stocks[0].ticker)
        Assertions.assertTrue(stocks[0].price > 0)
    }
}