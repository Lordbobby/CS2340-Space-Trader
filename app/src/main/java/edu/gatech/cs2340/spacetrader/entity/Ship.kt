package edu.gatech.cs2340.spacetrader.entity

import edu.gatech.cs2340.spacetrader.entity.inventory.Inventory
import edu.gatech.cs2340.spacetrader.entity.inventory.PlayerInventory

class Ship(type: ShipType) {
    constructor() : this(ShipType.GNAT)

    var type: ShipType = type
        private set(value) {
            field = value
        }

    val inventory: PlayerInventory = PlayerInventory(type.cargoCap)
    //TODO update with Good type once made

    fun updateShip(shipType: ShipType) {
        //TODO Implement
        //When you do, make sure you transfer that ship's inventory
    }

    override fun toString(): String {
        return "Type: $type\n" +
                "Inventory: $inventory"
    }
}