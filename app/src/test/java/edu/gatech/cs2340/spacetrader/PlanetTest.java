package edu.gatech.cs2340.spacetrader;

import org.junit.Assert;
import org.junit.Test;

import edu.gatech.cs2340.spacetrader.entity.PlanetResource;
import edu.gatech.cs2340.spacetrader.entity.TechLevel;
import edu.gatech.cs2340.spacetrader.model.Planet;
import edu.gatech.cs2340.spacetrader.util.Coordinate;

/**
 * Test methods in the Planet class
 */
public class PlanetTest {

    @Test
    public void testEqualReturnsFalseWithNull() {
        Planet planet = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);

        boolean result = planet.equals(null);

        Assert.assertFalse(result);
    }

    @Test
    public void testEqualReturnsFalseWithNonplanet() {
        Planet planet = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);

        boolean result = planet.equals("Test");

        Assert.assertFalse(result);
    }

    @Test
    public void testEqualReturnsFalseWithDifferentPlanet() {
        Planet planet = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);

        Planet other = new Planet("test1", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);
        boolean result = planet.equals(other);

        Assert.assertFalse(result);

        other = new Planet("test", new Coordinate(1, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);
        result = planet.equals(other);

        Assert.assertFalse(result);

        other = new Planet("test", new Coordinate(0, 0), PlanetResource.ARTISTIC, TechLevel.PRE_AGRICULTURE);
        result = planet.equals(other);

        Assert.assertFalse(result);


        other = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.HI_TECH);
        result = planet.equals(other);

        Assert.assertFalse(result);
    }

    @Test
    public void testEqualReturnsTrueWithEquality() {
        Planet planet = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);
        Planet other = new Planet("test", new Coordinate(0, 0), PlanetResource.NO_SPECIAL_RESOURCE, TechLevel.PRE_AGRICULTURE);
        boolean result = planet.equals(other);

        Assert.assertTrue(result);
    }
}
