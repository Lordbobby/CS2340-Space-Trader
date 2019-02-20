package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Skill
import edu.gatech.cs2340.spacetrader.views.NameFragment

class NameSelectionViewModel() {
    private var name = ""

    init {
        name = ""
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }
}