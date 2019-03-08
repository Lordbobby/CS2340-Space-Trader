package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.generators.UniverseGen
import edu.gatech.cs2340.spacetrader.model.interfaces.UniverseProvider
import edu.gatech.cs2340.spacetrader.util.Size
import edu.gatech.cs2340.spacetrader.viewmodel.UniverseMapViewModel
import edu.gatech.cs2340.spacetrader.views.UniverseMapActivity

class GameManager(val player: Player, val difficulty: GameDifficulty): UniverseProvider {

    private val universe: Universe = Universe(UniverseGen())
    var currentPlanet: Planet = universe.getRandomPlanet()

    override fun provide(): Universe {
        return universe
    }

    companion object {
        var INSTANCE: GameManager? = null
        var SIZE: Size? = null
        var UMVM: UniverseMapViewModel? = null
    }
}