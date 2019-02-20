package edu.gatech.cs2340.spacetrader.viewmodel

class NameSelectionViewModel(): GameSetup<String> {
    private var name = ""

    init {
        name = ""
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }

    override fun passPlayerData(): String {
        return name
    }
}