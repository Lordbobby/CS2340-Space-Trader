package edu.gatech.cs2340.spacetrader.generators

import edu.gatech.cs2340.spacetrader.util.Coordinate

interface Generator<T> {
    fun generate(): Map<Coordinate, T>
}