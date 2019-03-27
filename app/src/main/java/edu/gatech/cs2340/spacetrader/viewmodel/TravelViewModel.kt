package edu.gatech.cs2340.spacetrader.viewmodel

import android.content.Intent
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.views.TravelActivity
import edu.gatech.cs2340.spacetrader.views.UniverseMapActivity
import android.widget.Toast



class TravelViewModel {
    fun attemptTravel(planet1 : Planet) : Boolean{
        return (GameManager.INSTANCE!!.player.ship.canTravel(planet1,GameManager.INSTANCE!!.currentPlanet))
//        {
//            return true;
//           // GameManager.INSTANCE!!.currentPlanet = planet1
////            view.startActivity(Intent(view, UniverseMapActivity::class.java))
//        //    view.finish()
//        } else {
//            // notify can't travel ( will add it tonight)
////            val toast = Toast.makeText(getApplicationContext(),
////                    "This is a message displayed in a Toast",
////                    Toast.LENGTH_SHORT)
////
////            toast.show()
//            return false;
//        }
    }
}