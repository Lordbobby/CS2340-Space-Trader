package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameDifficulty
import edu.gatech.cs2340.spacetrader.viewmodel.ConfigurationViewModel
import kotlinx.android.synthetic.main.activity_configuration.*
import kotlinx.android.synthetic.main.fragment_game_difficulty.*
import kotlinx.android.synthetic.main.fragment_name_selection.*

class ConfigurationActivity : AppCompatActivity() {
    val configVM = ConfigurationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        start_game.setOnClickListener { view ->
            val toastText: String
            val playerNameVM = (name as NameFragment).nameVm
            val playerSkillVM = (skills as SkillFragment).skillVm
            val playerDifficultyVM = (difficulty as GameDifficultyFragment).difficultyVM

            //gets the values from the activity and sets it to their corresponding VM
            playerNameVM.setName(name.name_input.text.toString())
            playerDifficultyVM.setDifficulty(difficulty.gameDifficultySpinner.selectedItem as GameDifficulty)

            //validates the player
            if(configVM.createPlayer(playerNameVM,
                            playerSkillVM,
                            playerDifficultyVM)) {
                toastText = "Player successfully created!"
            } else {
                toastText = "Invalid player! make sure name is not empty and all skill points have been allocated"
            } //if all

            Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
        } //setOnClickListener
    } //onCreate
} //ConfigurationActivity
