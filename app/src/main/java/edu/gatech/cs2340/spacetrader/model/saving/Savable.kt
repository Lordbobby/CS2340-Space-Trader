package edu.gatech.cs2340.spacetrader.model.saving

import edu.gatech.cs2340.spacetrader.model.GameManager

interface Savable {
    fun save(manager: GameManager)
    fun load(): GameManager?

} //Savable