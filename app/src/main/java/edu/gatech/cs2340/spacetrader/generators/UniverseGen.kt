package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.model.SolarSystem
import kotlin.random.Random

class UniverseGen: SetGenerator<SolarSystem> {

    override fun generate(): Set<SolarSystem> {
        val universe = hashSetOf<SolarSystem>()
        val nameProvider = NameProvider()
        val coordGen = CoordinateGen()

        while (nameProvider.getNamesLeft() > 0) {
            val numPlanets = Random.nextInt(Math.max(nameProvider.getNamesLeft(), 5))
            val sysGenerator = PlanetGenerator(numPlanets, nameProvider, coordGen)
            val system = SolarSystem(sysGenerator)

            universe.add(system)
        }

        return universe
    } //generate
} //UniverseGenerator