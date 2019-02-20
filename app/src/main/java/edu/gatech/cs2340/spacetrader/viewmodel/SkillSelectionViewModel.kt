package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Skill

class SkillSelectionViewModel() {
    private var skillMap = mutableMapOf<Skill, Int>()
    private val skills = Skill.values()
    private val maxSkillPoints = 16
    private var usedSkillPoints = 0

    init {
        for(s : Skill in skills) {
            skillMap[s] = 0
        }
    }

    fun addSkillPoint(skill : Skill) {
        Log.d("SSVM", "Adding: ${usedSkillPoints} + 1 = ${usedSkillPoints + 1}")
        if (usedSkillPoints < maxSkillPoints) {
            skillMap[skill] = skillMap[skill]!! + 1
            usedSkillPoints++
        }
    }

    fun removeSkillPoint(skill : Skill) {
        Log.d("SSVM", "Removing: ${usedSkillPoints} - 1 = ${usedSkillPoints - 1}")
        if (usedSkillPoints > 0 && skillMap[skill]!! > 0) {
            skillMap[skill] = skillMap[skill]!! - 1
            usedSkillPoints--
        }
    }

    fun getUsedPoints() : Int {
        return usedSkillPoints
    }

    fun getPointsLeft() : Int {
        return maxSkillPoints - usedSkillPoints
    }

    fun getSkillPoints(skill : Skill) : Int {
        Log.d("SSVM", "Getting ${skillMap[skill]} points for ${skill.toString()}")
        return skillMap[skill]!!
    }

    //Use this to get the skill info
    fun getSkillMap() : MutableMap<Skill, Int> {
        return skillMap
    }
}