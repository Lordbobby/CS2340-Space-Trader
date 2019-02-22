package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.entity.PlanetResource
import edu.gatech.cs2340.spacetrader.entity.TechLevel
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.model.SolarSystem
import edu.gatech.cs2340.spacetrader.util.Coordinate

class PlanetGenerator(var planetNumber:Int, val names: NameProvider): Generator<Planet> {
    val resourceTypes = PlanetResource.values()
    val techLevels = TechLevel.values()

    override fun generate(): Map<Coordinate, Planet> {
        var solarSystem = HashMap<Coordinate, Planet>()
        var planets = (1 until 5).random()

        while(planets > 0) {
            val coord = Coordinate()
            val resource = resourceTypes[(0 until resourceTypes.size - 1).random()]
            val techLevel = techLevels[(0 until techLevels.size - 1).random()]
            val name =
            val planet = Planet(names.next(), coord, resource,techLevel)
            solarSystem.put(coord, planet)
            planets--
        } //while planets greater than 0

        return solarSystem
    } //generate
} //PlanetGenerator