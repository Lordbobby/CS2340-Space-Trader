package edu.gatech.cs2340.spacetrader;


import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import edu.gatech.cs2340.spacetrader.entity.Good;
import edu.gatech.cs2340.spacetrader.entity.inventory.PlayerInventory;

import static org.junit.Assert.assertEquals;

/**
 * Test for the sell method in transactional
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
    public void addItem() {
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

    @Test (expected = IllegalArgumentException.class)
    public void addItemFull() {
        inventory.put(Good.Firearms, 10);
        playerInventory.setSize(10);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());

        playerInventory.addToInv(Good.Firearms, 2);

        assertEquals(10, playerInventory.getSize());
        assertEquals(1, playerInventory.getInv().size());
        assertEquals((Integer) 10, playerInventory.getInv().get(Good.Firearms));
        assertEquals(10, playerInventory.getCap());
    } //addItemFull


} //sellTest
