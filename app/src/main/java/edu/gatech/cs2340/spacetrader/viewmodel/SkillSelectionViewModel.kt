package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Skill
import edu.gatech.cs2340.spacetrader.entity.SkillsData

class SkillSelectionViewModel(): GameSetup<SkillsData> {
    private var skillMap = mutableMapOf<Skill, Int>()
    private val skills = SkillsData(skillMap)
    private val maxSkillPoints = 16
    private var usedSkillPoints = 0

    fun addSkillPoint(skill : Skill) {
        //Log.d("SSVM", "Adding: ${usedSkillPoints} + 1 = ${usedSkillPoints + 1}")
        if (usedSkillPoints < maxSkillPoints) {
            skills.addPoint(skill)
            usedSkillPoints++
        }
    }

    fun removeSkillPoint(skill : Skill) {
        //Log.d("SSVM", "Removing: ${usedSkillPoints} - 1 = ${usedSkillPoints - 1}")
        if (usedSkillPoints > 0 && skillMap[skill]!! > 0) {
            skills.removePoint(skill)
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

    override fun passPlayerData(): SkillsData {
        return skills
    }
}