package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.model.Player

class ConfigurationViewModel {

    //creates a player and logs the data to the logcat if player is valid
    fun createPlayer(name:NameSelectionViewModel, skill:SkillSelectionViewModel, difficulty:GameDifficultyViewModel): Boolean {
        if(name.getName() == "") {
            return false
        } else if (skill.getUsedPoints() != 16) {
            return false
        } else {
            val playerName = name.passPlayerData()
            val playerSkill = skill.passPlayerData()
            val playerDifficulty = difficulty.passPlayerData()

            val player = Player(playerName, playerSkill, playerDifficulty, ShipType.GNAT)
            Log.d("SSVM", player.toString())
            return true
        } //if player valid
    } //createPlayer
} //ConfigurationViewModel