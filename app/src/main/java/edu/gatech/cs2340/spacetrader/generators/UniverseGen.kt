package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.model.SolarSystem
import edu.gatech.cs2340.spacetrader.util.Coordinate

class UniverseGen(): Generator<SolarSystem> {

    override fun generate(): Map<Coordinate, SolarSystem> {
        val universe = HashMap<Coordinate, SolarSystem>()
        val systemGenerator = PlanetGenerator()

        return universe
    } //generate
} //UniverseGenerator