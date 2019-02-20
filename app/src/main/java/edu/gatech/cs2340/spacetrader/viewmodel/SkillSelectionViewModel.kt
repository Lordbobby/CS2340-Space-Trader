package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Skill
import edu.gatech.cs2340.spacetrader.entity.SkillsData
import edu.gatech.cs2340.spacetrader.entity.validators.SkillValidator
import edu.gatech.cs2340.spacetrader.util.DataType
import edu.gatech.cs2340.spacetrader.util.SkilledData

class SkillSelectionViewModel: SkilledData, ValidatableConfigViewModel {
    private var skillMap = mutableMapOf<Skill, Int>()
    private val skills = SkillsData(skillMap)
    private var usedSkillPoints = 0
    private val validator: SkillValidator

    init {
        validator = SkillValidator(this)
    }

    fun addSkillPoint(skill : Skill) {
        //Log.d("SSVM", "Adding: ${usedSkillPoints} + 1 = ${usedSkillPoints + 1}")
        if (usedSkillPoints < MAX_SKILL_POINTS) {
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
        return MAX_SKILL_POINTS - usedSkillPoints
    }

    fun getSkillPoints(skill : Skill) : Int {
        Log.d("SSVM", "Getting ${skillMap[skill]} points for $skill")
        return skillMap[skill]!!
    }

    //Use this to get the skill info
    fun getSkillMap() : MutableMap<Skill, Int> {
        return skillMap
    }

    override fun isFullyAllocated(): Boolean {
        return usedSkillPoints == MAX_SKILL_POINTS
    }

    override fun validate(): Boolean {
        return validator.validate()
    }

    override fun getInvalidMessage(): String {
        return "All 16 skill points must be allocated!"
    }

    override fun processData(): Any {
        return skills
    }

    override fun getDataType(): DataType {
        return DataType.SKILLS
    }

    companion object {
        const val MAX_SKILL_POINTS = 16
    }
}