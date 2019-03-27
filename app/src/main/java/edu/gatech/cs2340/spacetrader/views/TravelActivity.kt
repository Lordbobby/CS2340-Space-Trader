package edu.gatech.cs2340.spacetrader.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Planet
import edu.gatech.cs2340.spacetrader.viewmodel.TravelViewModel
import kotlinx.android.synthetic.main.activity_travel.*

class TravelActivity : AppCompatActivity() {
    val viewModel = TravelViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)
        travel_msg.setText(
                getString(R.string.travel_msg, (intent.extras!!["Planet"] as Planet).name)
        )

        travel_cancel.setOnClickListener {
            startActivity(Intent(this, UniverseMapActivity::class.java))
            finish()
        }
        travel_go.setOnClickListener {
            viewModel.attemptTravel(intent.extras!!["Planet"] as Planet)
        }
    }
}
