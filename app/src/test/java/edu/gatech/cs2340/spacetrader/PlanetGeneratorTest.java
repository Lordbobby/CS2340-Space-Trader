package edu.gatech.cs2340.spacetrader;

import org.junit.Test;

import java.util.HashSet;

import edu.gatech.cs2340.spacetrader.entity.PlanetResource;
import edu.gatech.cs2340.spacetrader.entity.Ship;
import edu.gatech.cs2340.spacetrader.entity.TechLevel;
import edu.gatech.cs2340.spacetrader.generators.CoordinateGen;
import edu.gatech.cs2340.spacetrader.generators.NameProvider;
import edu.gatech.cs2340.spacetrader.model.Planet;
import edu.gatech.cs2340.spacetrader.model.SolarSystem;
import edu.gatech.cs2340.spacetrader.util.Coordinate;

import static org.junit.Assert.assertEquals;

public class PlanetGeneratorTest {
    @Test
    public void planetAreGenerated() {

        Planet planet1 = new Planet( "Earth", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.RENAISSANCE);
        Planet planet2 = new Planet("Mars", new Coordinate(0,10), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.RENAISSANCE);
        Ship myShip = new Ship();
        //myShip.addFuel(20);
        assertEquals(true,myShip.canTravel(planet1, planet2));
        Planet planet3 = new Planet( "Earth", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.RENAISSANCE);
        Planet planet4 = new Planet("Mars", new Coordinate(0,30), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.RENAISSANCE);
        Ship myShip2 = new Ship();
       // myShip2.addFuel(20);
        assertEquals(false,myShip2.canTravel(planet3, planet4));

    }
}
