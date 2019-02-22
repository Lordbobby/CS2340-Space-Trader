package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.model.SolarSystem
import edu.gatech.cs2340.spacetrader.util.Coordinate

class UniverseGen(): Generator<SolarSystem> {

    override fun generate(): Map<Coordinate, SolarSystem> {
        val universe = HashMap<Coordinate, SolarSystem>()
        var listPlace = 0
        val systemGenerator = PlanetGenerator()
        while(systemGenerator.listEnded()) {
            val solarSystem = SolarSystem(Coordinate(), systemGenerator)
        } //while listPlace less than names.length

        return universe
    } //generate
} //UniverseGenerator