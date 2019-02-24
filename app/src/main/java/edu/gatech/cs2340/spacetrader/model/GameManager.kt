package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.generators.UniverseGen
import edu.gatech.cs2340.spacetrader.model.interfaces.UniverseProvider

class GameManager(private val player: Player, val difficulty: GameDifficulty): UniverseProvider {

    private val universe: Universe = Universe(UniverseGen())
    var currentPlanet: Planet = universe.getRandomPlanet()
        private set

    override fun provide(): Universe {
        return universe
    }

    companion object {
        var INSTANCE: GameManager? = null;
    }
}