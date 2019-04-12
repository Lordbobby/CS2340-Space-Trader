package edu.gatech.cs2340.spacetrader;


import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import edu.gatech.cs2340.spacetrader.entity.Good;
import edu.gatech.cs2340.spacetrader.entity.inventory.PlayerInventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for the addToInv method in PlayerInventory
 */
public class PlayerInventoryAddTest {

    HashMap<Good, Integer> inventory;
    PlayerInventory playerInventory;


    @Before
    public void setUp() {
        inventory = new HashMap<>();
        playerInventory = new PlayerInventory(10, inventory);
    } //setUp

    @Test
    public void addItemTest() {
        assertEquals(new HashMap<Good, Integer>(), playerInventory.getInv());
        assertEquals(0, playerInventory.getInv().size());
        assertEquals(0, playerInventory.getSize());
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 3);
        inventory.put(Good.Firearms, 3);
        assertEquals(1, playerInventory.getInv().size());
        assertEquals(3, playerInventory.getSize());
        assertEquals(10, playerInventory.getCap());

    } //add item

    @Test
    public void addDifferentItemsest() {
        assertEquals(new HashMap<Good, Integer>(), playerInventory.getInv());
        assertEquals(0, playerInventory.getInv().size());
        assertEquals(0, playerInventory.getSize());
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 3);
        inventory.put(Good.Firearms, 3);

        assertEquals(1, playerInventory.getInv().size());
        assertEquals(3, playerInventory.getSize());
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Furs, 6);
        inventory.put(Good.Furs, 6);

        assertEquals(9, playerInventory.getSize());
        assertEquals(10, playerInventory.getCap());
        assertEquals(2, playerInventory.getInv().size());
        assertEquals((Integer) 3, playerInventory.getInv().get(Good.Firearms));
        assertEquals((Integer) 6, playerInventory.getInv().get(Good.Furs));



    } //add item

    @Test (expected = IllegalArgumentException.class)
    public void addItemInventoryFullTest() {
        inventory.put(Good.Firearms, 10);
        playerInventory.setSize(10);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 2);
        inventory.put(Good.Firearms, 7);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
    } //addItemFull

    @Test (expected = IllegalArgumentException.class)
    public void addItemUntilFullTest() {
        inventory.put(Good.Firearms, 5);
        playerInventory.setSize(5);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 2);

        assertEquals(7, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 7, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 3);
        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 1);
        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 2);
        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addFullDifferentItemTest() {

        inventory.put(Good.Firearms, 10);
        playerInventory.setSize(10);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Food, 2);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
        assertNull(playerInventory.getInv().get(Good.Food));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addItemQuantityZero() {
        inventory.put(Good.Firearms, 5);
        playerInventory.setSize(5);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 0);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addItemQuantityNegative() {

        inventory.put(Good.Firearms, 5);
        playerInventory.setSize(5);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, -2);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addDifferentItemQuantityZero() {
        inventory.put(Good.Firearms, 5);
        playerInventory.setSize(5);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Food, 0);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
        assertNull(playerInventory.getInv().get(Good.Food));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addDifferentItemQuantityNegative() {
        inventory.put(Good.Firearms, 5);
        playerInventory.setSize(5);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Food, -3);

        assertEquals(5, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 5, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
        assertNull(playerInventory.getInv().get(Good.Food));
    }


} //sellTest
