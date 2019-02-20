package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.viewmodel.ConfigurationViewModel
import kotlinx.android.synthetic.main.activity_configuration.*

class ConfigurationActivity : AppCompatActivity() {
    val configVM = ConfigurationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        start_game.setOnClickListener { view ->
            configVM.createPlayer()
        } //setOnClickListener

    } //onCreate
} //ConfigurationActivity
