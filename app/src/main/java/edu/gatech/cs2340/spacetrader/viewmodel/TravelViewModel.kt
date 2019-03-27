package edu.gatech.cs2340.spacetrader.viewmodel

import android.content.Intent
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.views.TravelActivity
import edu.gatech.cs2340.spacetrader.views.UniverseMapActivity

class TravelViewModel(private val view : TravelActivity){
    fun attemptTravel(planet1 : Planet) {
        if (GameManager.INSTANCE!!.player.ship.canTravel(planet1,GameManager.INSTANCE!!.currentPlanet)) {
            GameManager.INSTANCE!!.currentPlanet = planet1
            view.startActivity(Intent(view, UniverseMapActivity::class.java))
            view.finish()
        } else {
            // notify can't travel ( will add it tonight)
        }
    }
}