package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.entity.PlanetResource
import edu.gatech.cs2340.spacetrader.entity.TechLevel
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.model.SolarSystem
import edu.gatech.cs2340.spacetrader.util.Coordinate

class PlanetGenerator(var planets:Int, val names: NameProvider): Generator<Planet> {
    private val resourceTypes = PlanetResource.values()
    private val techLevels = TechLevel.values()

    override fun generate(): Map<Coordinate, Planet> {
        var solarSystem = HashMap<Coordinate, Planet>()

        while(planets > 0) {
            val coord = Coordinate()
            val resource = resourceTypes[(0 until resourceTypes.size - 1).random()]
            val techLevel = techLevels[(0 until techLevels.size - 1).random()]
            val name = names.next()
            val planet = Planet(name, coord, resource,techLevel)
            solarSystem.put(coord, planet)
            planets--
        } //while planets greater than 0

        return solarSystem
    } //generate
} //PlanetGenerator