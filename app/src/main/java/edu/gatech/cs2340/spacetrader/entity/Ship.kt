package edu.gatech.cs2340.spacetrader.entity

class Ship(type: ShipType = ShipType.GNAT) {
    var type: ShipType = type
    private set(value) {
        field = value
    }

    fun updateShip(shipType: ShipType) {
        //TODO Implement
    }
}