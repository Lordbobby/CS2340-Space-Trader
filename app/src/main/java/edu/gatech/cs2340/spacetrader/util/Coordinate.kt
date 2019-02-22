package edu.gatech.cs2340.spacetrader.util

data class Coordinate(val x: Int, val y: Int) {

    fun calculateDistance (coordinate: Coordinate): Double {
        return Math.sqrt(Math.pow((x - coordinate.x).toDouble(), 2.0) + Math.pow((y - coordinate.y).toDouble(), 2.0))
    }

    override fun toString(): String {
        return "{x=$x,y=$y}"
    }
}