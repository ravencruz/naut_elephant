package org.ground.play.core

class Deck {

    //limitation: only one companion object is available for each class
    companion object {
        val size = 10
        val height = 2
        fun volume(bottom: Int, height: Int) = bottom * height
    }

    val square = size * size             //100
    val volume = volume(square, height)  //200
}