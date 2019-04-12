package edu.gatech.cs2340.spacetrader.entity.inventory

import edu.gatech.cs2340.spacetrader.entity.Good
import java.io.Serializable

abstract class Inventory: Serializable {
    abstract val inv: MutableMap<Good, Int>
    abstract var cap: Int
    abstract var size: Int

    fun addToInv(good: Good, v: Int) {
        if (size + v < cap && v > 0) {
            if (inv[good] == null) inv[good] = v else inv[good] = inv[good]!! + v
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