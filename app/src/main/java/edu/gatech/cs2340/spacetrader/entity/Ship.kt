package edu.gatech.cs2340.spacetrader.entity

import edu.gatech.cs2340.spacetrader.entity.inventory.Inventory
import edu.gatech.cs2340.spacetrader.entity.inventory.PlayerInventory
import edu.gatech.cs2340.spacetrader.model.Planet

class Ship(type: ShipType) {
    constructor() : this(ShipType.GNAT)

    var type: ShipType = type
        private set(value) {
            field = value
        }

    var fuel: Int = 0
    fun getFuelLevel ():Int {
        return fuel
    }
    fun addFuel(fuelToAdd: Int) {
        fuel += fuelToAdd
    }
    fun removeFuel(fuelToBeremoved: Int) {
        fuel -= fuelToBeremoved
    }
    fun canTravel(planet1: Planet, planet2: Planet): Boolean {
        if (fuel > Math.sqrt(Math.pow((planet2.coordinate.x - planet1.coordinate.x).toDouble(), 2.0) +
                        Math.pow((planet2.coordinate.y- planet1.coordinate.y).toDouble(), 2.0))) {
            return true
        }
        return false
    }

    val inventory: PlayerInventory = PlayerInventory(type.cargoCap)

    fun updateShip(shipType: ShipType) {
        //TODO Implement
        //When you do, make sure you transfer that ship's inventory
    }

    override fun toString(): String {
        return "Type: $type\n" +
                "Inventory: $inventory\n" +
                "Fuel: $fuel"
    }
}