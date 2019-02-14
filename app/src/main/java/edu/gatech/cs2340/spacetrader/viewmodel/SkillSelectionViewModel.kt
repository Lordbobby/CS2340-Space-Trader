package edu.gatech.cs2340.spacetrader.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.support.v4.app.Fragment
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.Config
import edu.gatech.cs2340.spacetrader.model.Skill
import kotlinx.android.synthetic.main.fragment_skill_selection.*;

class SkillSelectionViewModel(app: Application) : AndroidViewModel(app) {
    val maxPoints : Int = 16
    var pointsUsed : Int = 0
    val config: Config = Config()

    fun addPoint(enum: Skill) {

    }
}