package edu.gatech.cs2340.spacetrader.model.encounter

import edu.gatech.cs2340.spacetrader.model.Player

interface Encounter {

    fun initiateEncounter(player: Player)
}