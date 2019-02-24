package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.model.Universe
import edu.gatech.cs2340.spacetrader.util.Coordinate

class CoordinateGen: Generator<Coordinate>{
    var currBase = Coordinate(0 , 0)
    private val occupiedCorrdinates: HashSet<Coordinate> = HashSet()

    fun generateBasePoint() {
        val x = (5 until (Universe.MAX_X - 5)).random()
        val y = (5 until (Universe.MAX_Y - 5)).random()
        currBase = Coordinate(x, y)
    } //generateBasePoint

    override fun generate(): Coordinate {
        val x = ((currBase.x - 5) until (currBase.x + 5)).random()
        val y = ((currBase.y - 5) until (currBase.y + 5)).random()
        val coordinate = linearProbe(x, y, 1)

        occupiedCorrdinates.add(coordinate)
        return coordinate
    } //generate

    private fun linearProbe(x:Int, y:Int, step:Int):Coordinate {
        var newX = x
        var newY = y
        var coordinate = Coordinate(x , y)

        //linear probes the coordinates until free space is found
        while(occupiedCorrdinates.contains(coordinate)) {
            newX += step
            newY += step
            coordinate = Coordinate(newX, newY)
        } //while the coordinate exists in the universe
        return coordinate
    } //linearProbe

} //CoordinateGen