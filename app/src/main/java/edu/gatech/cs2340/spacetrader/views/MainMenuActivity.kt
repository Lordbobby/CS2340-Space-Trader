package edu.gatech.cs2340.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R

import kotlinx.android.synthetic.main.activity_main.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Main Menu"
        setSupportActionBar(toolbar)
        newGame.setOnClickListener { view ->
            val intent = Intent(this, ConfigurationActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener { view ->
            val intent = Intent(this, UniverseMapActivity::class.java)
            startActivity(intent)
        }
    }

}
