package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.entity.SkillsData
import edu.gatech.cs2340.spacetrader.model.GameDifficulty
import edu.gatech.cs2340.spacetrader.model.Player
import edu.gatech.cs2340.spacetrader.util.DataType
import edu.gatech.cs2340.spacetrader.views.interfaces.ConfigViewModelProvider

class ConfigurationViewModel {

    fun onDataSubmission(vmProviders: List<ConfigViewModelProvider>): String {
        var dataMap = mutableMapOf<DataType, Any>()

        for (provider in vmProviders) {
            val vm = provider.provideVM()

            if(vm is ValidatableConfigViewModel) {
                val valid = vm.validate()

                if(!valid) {
                    return vm.getInvalidMessage()
                }
            }

            dataMap[vm.getDataType()] = vm.processData()
        }

        val name = dataMap[DataType.NAME] as String
        val skills = dataMap[DataType.SKILLS] as SkillsData
        val diff = dataMap[DataType.DIFFICULTY] as GameDifficulty

        createPlayer(name, skills, diff)
        return "Player created successfully!"
    }

    //creates a player and logs the data to the logcat if player is valid
    private fun createPlayer(name: String, skill: SkillsData, difficulty: GameDifficulty) {
        val player = Player(name, skill, difficulty, ShipType.GNAT)
        Log.d("SSVM", player.toString())
    } //createPlayer
} //ConfigurationViewModel