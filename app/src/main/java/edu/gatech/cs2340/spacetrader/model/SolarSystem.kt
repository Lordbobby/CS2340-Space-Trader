package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.generators.Generator
import edu.gatech.cs2340.spacetrader.util.Coordinate

class SolarSystem(val coordinate: Coordinate, generator: Generator<Planet>) {
    private val planets = generator.generate()
}