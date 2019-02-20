package edu.gatech.cs2340.spacetrader.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Ship
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.model.Player

class ConfigurationViewModel() {
    fun createPlayer(name:NameSelectionViewModel, skill:SkillSelectionViewModel, difficulty:GameDifficultyViewModel) {
        val playerName = name.passPlayerData()
        val playerSkill = skill.passPlayerData()
        val playerDifficulty = difficulty.passPlayerData()

        val player = Player(playerName, playerSkill, playerDifficulty, ShipType.GNAT)
        Log.d("SSVM", player.toString())
    } //createPlayer

    fun validate(name:NameSelectionViewModel, skill:SkillSelectionViewModel):Boolean {
        return name.getName() != "" && skill.getUsedPoints() == 16
    }
} //ConfigurationViewModel