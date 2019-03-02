package edu.gatech.cs2340.spacetrader.entity.inventory

import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.GameManager
import java.lang.IllegalArgumentException

class PlayerInventory(cap: Int, goods: MutableMap<Good, Int>): Inventory {

    constructor(cap: Int) : this(cap, mutableMapOf())

    override val inv: MutableMap<Good, Int> = goods
    override var cap: Int = cap
    override var size: Int = 0
    override var planet = GameManager.INSTANCE!!.currentPlanet

    fun valueOf(): Int {
        val total = 0
//        inv.forEach {
//            total +=
//        }
        //TODO Calc value of inventory
        return total
    }

    override fun toString(): String {
        var string = ""
        inv.forEach {
            string += "Good: ${it.key}, Quantity: ${it.value}\n"
        }
        return string
    }
}