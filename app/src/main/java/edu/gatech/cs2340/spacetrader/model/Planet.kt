package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.PlanetResource
import edu.gatech.cs2340.spacetrader.entity.TechLevel
import edu.gatech.cs2340.spacetrader.entity.inventory.PlanetInventory
import edu.gatech.cs2340.spacetrader.util.Coordinate

class Planet(val name: String, val coordinate: Coordinate, val resource: PlanetResource, val techLevel: TechLevel) {

    var solarSystem: SolarSystem? = null
    val inventory: PlanetInventory = PlanetInventory(this)

    override fun toString(): String {
        return "{name=$name,coord=$coordinate,resource=$resource,tech_level=$techLevel}"
    }


}