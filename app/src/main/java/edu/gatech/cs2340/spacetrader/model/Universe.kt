package edu.gatech.cs2340.spacetrader.model

import android.os.Handler
import edu.gatech.cs2340.spacetrader.generators.SetGenerator
import edu.gatech.cs2340.spacetrader.runnable.IncreaseEventRunnable
import edu.gatech.cs2340.spacetrader.util.Coordinate
import java.io.Serializable

class Universe(generator: SetGenerator<SolarSystem>): Serializable {
    private val systems: Set<SolarSystem> = generator.generate()

    init {
        val increaseEventHandler = Handler()
        val runnable = IncreaseEventRunnable(increaseEventHandler, this, 100)

        runnable.start()
    }

    fun calculateClosePlanets(coord: Coordinate, range: Int = 7): Map<Coordinate, Planet> {
        val closeSystems = hashMapOf<Coordinate, Planet>()

        systems.forEach {
            it.addClosePlanets(closeSystems, coord, range)
        }

        return closeSystems
    }

    fun getRandomPlanet(): Planet {
        return systems.random().getRandomPlanet()
    }

    override fun toString(): String {
        val builder = StringBuilder("{")

        systems.forEach {
            builder.append(it)
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