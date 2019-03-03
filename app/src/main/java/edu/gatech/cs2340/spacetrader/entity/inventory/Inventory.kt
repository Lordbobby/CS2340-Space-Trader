package edu.gatech.cs2340.spacetrader.entity.inventory

import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.Planet
import java.lang.IllegalArgumentException

interface Inventory {
    val inv: MutableMap<Good, Int>
    var cap: Int
    var size: Int

    fun addToInv(good: Good, v: Int) {
        if (size + v < cap) {
            if (inv[good] == null) inv.put(good, v) else inv[good]!! + v
            size += v
        } else {
            throw IllegalArgumentException(
                    "Cannot add more items than inventory capacity"
            )
        }
    }

    fun removeFromInv(good: Good, v: Int) {
        if (inv[good] != null && inv[good]!! - v >= 0) {
            inv[good] = inv[good]!! - v
            size -= v
        } else {
            throw IllegalArgumentException(
                    "Cannot remove more items than present in inventory"
            )
        }
    }
}