package edu.gatech.cs2340.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.entity.GameDifficulty
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.entity.SkillsData
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.Player
import edu.gatech.cs2340.spacetrader.model.saving.Savable
import edu.gatech.cs2340.spacetrader.model.saving.SerialSave
import edu.gatech.cs2340.spacetrader.util.Size
import edu.gatech.cs2340.spacetrader.viewmodel.MainMenuViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainMenuActivity : AppCompatActivity() {
    private val viewModel = MainMenuViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Main Menu"
        setSupportActionBar(toolbar)

        newGame.setOnClickListener {
            val intent = Intent(this, ConfigurationActivity::class.java)
            startActivity(intent)
        }//newGame click listener

        button.setOnClickListener {
            val gameMan = GameManager(Player("Test", SkillsData(mutableMapOf()), ShipType.GNAT), GameDifficulty.BEGINNER)
            val layout = coordinatorLayout
            val width = layout.width
            val height = layout.height

            GameManager.SIZE = Size(width, height)
            GameManager.INSTANCE = gameMan
            val intent = Intent(this, UniverseMapActivity::class.java)
            startActivity(intent)
        } //button click listener

        loadGameButton.setOnClickListener{
            viewModel.load()
        } //loadGameButton click listener
    } //onCreate
} //MainMenuActivity
