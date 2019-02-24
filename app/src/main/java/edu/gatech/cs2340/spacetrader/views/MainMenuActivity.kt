package edu.gatech.cs2340.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.entity.SkillsData
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Player
import kotlinx.android.synthetic.main.activity_main.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Main Menu"
        setSupportActionBar(toolbar)
        newGame.setOnClickListener {
            val intent = Intent(this, ConfigurationActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val gameMan = GameManager(Player("Test", SkillsData(mutableMapOf()), ShipType.GNAT), GameDifficulty.BEGINNER)

            GameManager.INSTANCE = gameMan
            val intent = Intent(this, UniverseMapActivity::class.java)
            startActivity(intent)
        }
    }

}
