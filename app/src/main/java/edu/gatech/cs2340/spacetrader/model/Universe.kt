package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.generators.MappedGenerator
import edu.gatech.cs2340.spacetrader.util.Coordinate

class Universe(generator: MappedGenerator<SolarSystem>) {
    private val systems: Map<Coordinate, SolarSystem> = generator.generate()

    fun calculateClosePlanets(coord: Coordinate, range: Int = 10): Map<Coordinate, Planet> {
        val closeSystems = hashMapOf<Coordinate, Planet>()

        systems.forEach {
            it.value.addClosePlanets(closeSystems, coord, range)
        }

        return closeSystems
    }

    override fun toString(): String {
        val builder = StringBuilder("{")

        systems.forEach {
            builder.append(it.value)
            builder.append(", ")
        }

        builder.delete(builder.length - 2, builder.length)
        builder.append("}")
        return super.toString()
    }

    companion object {
        const val MAX_X = 100
        const val MAX_Y = 100
    }
}