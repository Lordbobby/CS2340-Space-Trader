package edu.gatech.cs2340.spacetrader.model.saving

import android.content.Context
import edu.gatech.cs2340.spacetrader.model.GameManager

interface Savable {
    fun save(manager: GameManager, context: Context): Boolean
    fun load(context: Context): Boolean

} //Savable