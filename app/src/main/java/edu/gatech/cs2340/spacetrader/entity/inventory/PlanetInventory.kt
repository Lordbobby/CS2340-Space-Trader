package edu.gatech.cs2340.spacetrader.entity.inventory

import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.util.Constants

class PlanetInventory(planet: Planet): Inventory {
    override val inv: MutableMap<Good, Int> = mutableMapOf()
    override var cap: Int = Int.MAX_VALUE
    override var size: Int = 0

    //Generate planet inventory on planet creation
    init {
        for(g: Good in Good.values()) {
            if (g.MTLP <= planet.techLevel) {
                inv.put(g, (0..Constants.MAX_GOODS_PER_PLANET).random())
            }
        }
    }
}