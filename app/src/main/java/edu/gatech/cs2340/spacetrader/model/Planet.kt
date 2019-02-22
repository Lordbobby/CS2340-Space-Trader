package edu.gatech.cs2340.spacetrader.model

import edu.gatech.cs2340.spacetrader.entity.PlanetResource
import edu.gatech.cs2340.spacetrader.entity.TechLevel
import edu.gatech.cs2340.spacetrader.util.Coordinate

class Planet(val name: String, val coordinate: Coordinate, val resource: PlanetResource, val techLevel: TechLevel) {
}