package org.ground.play.core

/**
 * However, there can be many classes and related singletons, which makes the code confusing and difficult to read.
 * Another way to store this information is by using a nested object.
 */
object PlayerProperties {
    /* Default player speed in playing field – 7 cells per turn */
    val defaultSpeed = 7

    fun calcMovePenalty(cell: Int): Int {
        /* calc move speed penalty */
        TODO()
    }
}