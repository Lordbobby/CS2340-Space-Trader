package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.GameDifficulty

class GameManager(private val player: Player, val difficulty: GameDifficulty) {

    private val universe: Universe = Universe()

}