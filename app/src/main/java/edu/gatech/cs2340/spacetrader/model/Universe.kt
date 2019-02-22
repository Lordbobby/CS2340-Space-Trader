package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.generators.Generator
import edu.gatech.cs2340.spacetrader.util.Coordinate

class Universe(private val generator: Generator<SolarSystem>) {
    private val systems: Map<Coordinate, SolarSystem> = generator.generate()


}