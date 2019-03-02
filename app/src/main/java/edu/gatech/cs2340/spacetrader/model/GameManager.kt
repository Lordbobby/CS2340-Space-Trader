package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.generators.UniverseGen
import edu.gatech.cs2340.spacetrader.model.interfaces.UniverseProvider
import edu.gatech.cs2340.spacetrader.util.Size

class GameManager(private val player: Player, val difficulty: GameDifficulty): UniverseProvider {

    private val universe: Universe = Universe(UniverseGen())
    var currentPlanet: Planet = universe.getRandomPlanet()
        private set
    val MAX_GOOD_PER_PLANET: Int = 25

    override fun provide(): Universe {
        return universe
    }

    companion object {
        var INSTANCE: GameManager? = null
        var SIZE: Size? = null
    }
}