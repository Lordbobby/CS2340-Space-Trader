package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.model.Universe
import edu.gatech.cs2340.spacetrader.util.Coordinate

class CoordinateGen: Generator<Coordinate>{
    var currBase = Coordinate(0 , 0)
    var baseGen = false
    private val occupiedCorrdinates: HashSet<Coordinate> = HashSet()

    fun generateBasePoint() {
        baseGen = true
        val basePoint = generate()
        currBase = basePoint

    } //generateBasePoint

    override fun generate(): Coordinate {
        var coordinate: Coordinate
        var x: Int
        var y: Int
        if(baseGen) {
            //generates random values of the coordinates
            x = (0 until Universe.MAX_X).random()
            y = (0 until Universe.MAX_Y).random()
            coordinate = linearProbe(x, y, 2)
            baseGen = false
        } else {
            x = ((Universe.MAX_X - 5) until (Universe.MAX_X + 5)).random()
            y = ((Universe.MAX_Y - 5) until (Universe.MAX_Y + 5)).random()
            coordinate = linearProbe(x, y, 1)
        }

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