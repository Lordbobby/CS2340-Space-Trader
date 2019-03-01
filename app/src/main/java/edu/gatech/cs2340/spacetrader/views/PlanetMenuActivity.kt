package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.viewmodel.PlanetMenuViewModel
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameManager
import kotlinx.android.synthetic.main.activity_planet_menu.*

class PlanetMenuActivity: AppCompatActivity() {
    private val viewModel = PlanetMenuViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_menu)

        welcome.setText(
                "Welcome to " + GameManager.INSTANCE!!.currentPlanet.name + "! What would you like to do?"
        )

    } //onCreate
} //PlanetMenuActivity