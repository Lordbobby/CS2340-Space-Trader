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
            (name as NameFragment).nameVm.setName(name.name_input.text.toString())
            (difficulty as GameDifficultyFragment).difficultyVM.setDifficulty((difficulty.gameDifficultySpinner.selectedItem as GameDifficulty))
            val toastText: String

            if(configVM.validate((name as NameFragment).nameVm, (skills as SkillFragment).skillVm)) {
                configVM.createPlayer((name as NameFragment).nameVm,
                        (skills as SkillFragment).skillVm,
                        (difficulty as GameDifficultyFragment).difficultyVM)
                toastText = "Player successfully created!"
            } else {
                toastText = "Invalid player! make sure name is not empty and all skill points have been allocated"
            }

            Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
        } //setOnClickListener
    } //onCreate
} //ConfigurationActivity
