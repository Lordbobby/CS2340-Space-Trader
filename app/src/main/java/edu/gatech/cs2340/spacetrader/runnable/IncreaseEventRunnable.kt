package edu.gatech.cs2340.spacetrader.runnable

import android.os.Handler
import edu.gatech.cs2340.spacetrader.entity.IncreaseEvent
import edu.gatech.cs2340.spacetrader.model.Universe
import java.util.*

class IncreaseEventRunnable(private val handler: Handler, private val universe: Universe, val maxPlanets: Int) : Runnable {

    fun start() {
        handler.post(this)
    }

    override fun run() {
        for (i in 1..Random().nextInt(maxPlanets)) {
            val planet = universe.getRandomPlanet()

            if ( planet.event == IncreaseEvent.NONE)
                planet.event = IncreaseEvent.values().random()
            else
                planet.event = IncreaseEvent.NONE
        }

        handler.postDelayed(this, 1000 * 30) //run every 30 seconds
    }
}