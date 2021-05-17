package org.ground.play.core

class Player(val id: Int, val name: String = "") {

    // You can also use properties and functions from a nested object in the outer class.
    val superSpeed = Properties.defaultSpeed * 2 // 14

    /**
     * Often you need to create a singleton that is somehow related to another class
     */
    companion object Properties {
        val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {/* calc move speed penalty */
            TODO()
        }
    }

    /**
     * However, we can create one companion object and some nested objects:
     * This pattern is called Factory creates a new instance of Player
     **/
    object Factory {
        fun create(playerId: Int): Player {
            return Player(playerId)
        }
    }
}

/**
 * This's how you can create a singleton connected to a special class.
 * Use a companion object when you need one singleton associated with a class.
 * It is preferable to use a companion object rather than a nested class. Now, let's move on to practice!
 *
 * When do you need to declare a companion object? Select all that apply.
 * You want some properties to be the same for all instances of the class
 * You need one structure connected to a class rather than to its instances.
 *
 * The opposite is not true. You cannot use the properties and the functions of the outer class in the inner.
 * For example, you cannot do something like that:
 *
 */
fun main() {
    println(Player.Properties.defaultSpeed)
    println(Player.defaultSpeed)//since its a companion
    println(Player.Factory.create(13).id)
}

/**
 * There is one more limitation: we cannot create a companion object inside another singleton (and companion object, too), because that violates the global access principle.
    object OuterSingleton {
        companion object InnerSingleton{ // Modifier 'companion' is not applicable inside 'object'
    }
}*/