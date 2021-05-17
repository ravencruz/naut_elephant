package org.ground.play.core

class GameLogic {
    fun startNewGameTurn() {
        val players = PlayingField.getAllPlayers()
        if (players.size < 2) {
            return println("The game cannot be continued without players")
        }
        for (player in players) {
            nextPlayerTurn(player)
        }
    }

    fun nextPlayerTurn(player: Player) {
        if (!PlayingField.isPlayerInGame(player)) {
            return println("Current player lost. Next...")
        }
        /* Player actions here */
    }
}

