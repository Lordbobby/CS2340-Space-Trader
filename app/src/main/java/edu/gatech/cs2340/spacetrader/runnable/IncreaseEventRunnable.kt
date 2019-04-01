package edu.gatech.cs2340.spacetrader.runnable

import android.os.Handler
import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.IncreaseEvent
import edu.gatech.cs2340.spacetrader.model.Universe
import java.util.*

class IncreaseEventRunnable(private val handler: Handler, private val universe: Universe, private val maxPlanets: Int) : Runnable {

    fun start() {
        handler.post(this)
    }

    override fun run() {
        val half = maxPlanets / 2
        for (i in half..half + Random().nextInt(half)) {
            val planet = universe.getRandomPlanet()

            if ( planet.event == IncreaseEvent.NONE) {
                planet.event = IncreaseEvent.values().random()
                Log.d("IR", "Planet: " + planet.name)
            } else {
                planet.event = IncreaseEvent.NONE
            }
        }

        handler.postDelayed(this, 1000 * 30) //run every 30 seconds
    }
}