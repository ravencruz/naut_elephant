package org.ground.play.beans

import io.micronaut.core.annotation.Introspected

@Introspected
data class CryptoPrice(val lprice: String, val curr1: String, val curr2: String)
