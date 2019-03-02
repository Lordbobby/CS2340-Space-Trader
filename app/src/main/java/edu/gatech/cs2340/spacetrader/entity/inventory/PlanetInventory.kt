package edu.gatech.cs2340.spacetrader.entity.inventory

import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.Planet

class PlanetInventory(planet: Planet): Inventory {
    override val inv: MutableMap<Good, Int> = mutableMapOf()
    override var cap: Int = Int.MAX_VALUE
    override var size: Int = 0
    override var planet: Planet = planet

//    init {
//        for(g: Good in Good.values()) {
//            if (g.MTLP.compareTo(planet.techLevel)) {
//
//            }
//        }
//    }
}