package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.model.Skill

class NameSelectionViewModel() {
    private var name = ""

    init {
        name = ""
    }

    fun getName(): String {
        return name
    }
}