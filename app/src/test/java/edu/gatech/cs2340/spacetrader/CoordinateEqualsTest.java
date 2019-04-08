package edu.gatech.cs2340.spacetrader;

import org.junit.Assert;
import org.junit.Test;

import edu.gatech.cs2340.spacetrader.util.Coordinate;

/**
 * Test for Coordinate equals method
 */
public class CoordinateEqualsTest {

    /**
     * Test for equals method
     */
    @Test
    public void equals() {
        Coordinate c1 = new Coordinate(0, 0);
        Object fakeCoord = new Object();
        Assert.assertFalse(c1.equals(fakeCoord));
        Coordinate wrongX = new Coordinate(1, 0);
        Assert.assertFalse(c1.equals(wrongX));
        Coordinate wrongY = new Coordinate(0, 1);
        Assert.assertFalse(c1.equals(wrongY));
        Coordinate wrongBoth = new Coordinate(1, 1);
        Assert.assertFalse(c1.equals(wrongBoth));
        Coordinate rightBoth = new Coordinate(0, 0);
        Assert.assertTrue(c1.equals(rightBoth));
        Assert.assertTrue(c1.equals(c1));
    }
}