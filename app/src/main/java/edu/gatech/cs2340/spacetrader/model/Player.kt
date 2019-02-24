package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.Ship
import edu.gatech.cs2340.spacetrader.entity.ShipType
import edu.gatech.cs2340.spacetrader.entity.SkillsData

class Player(val name: String, var credits: Int, var skills: SkillsData, var ship: Ship) {

    constructor(name: String, skills: SkillsData, ship: ShipType) : this(name, 1000, skills, Ship())

    override fun toString(): String {
        return "The Player: {$name} with skills in {$skills}"
    }
} //Player