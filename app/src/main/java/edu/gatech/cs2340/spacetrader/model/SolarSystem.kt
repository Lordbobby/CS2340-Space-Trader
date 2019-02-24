package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.generators.MappedGenerator
import edu.gatech.cs2340.spacetrader.util.Coordinate

class SolarSystem(generator: MappedGenerator<Planet>) {
    private val planets = generator.generate()

    fun addClosePlanets(map: MutableMap<Coordinate, Planet>, coord: Coordinate, range:Int) {
        planets.forEach {
            if (it.key.calculateDistance(coord) < range) {
                map[it.key] = it.value
            }
        }
    }

    fun getRandomPlanet(): Planet {
        return planets.values.random()
    }

    override fun toString(): String {
        val builder = StringBuilder("{")

        planets.forEach{
            builder.append(it.value)
            builder.append(", ")
        }

        builder.delete(builder.length - 2, builder.length)
        builder.append("}")

        return builder.toString()
    }
}