package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.generators.UniverseGen

class GameManager(private val player: Player, val difficulty: GameDifficulty) {

    private val universe: Universe = Universe(UniverseGen())

}