package edu.gatech.cs2340.spacetrader.viewmodel

import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.Skill
import edu.gatech.cs2340.spacetrader.entity.SkillsData
import edu.gatech.cs2340.spacetrader.entity.validators.SkillValidator
import edu.gatech.cs2340.spacetrader.util.DataType
import edu.gatech.cs2340.spacetrader.util.SkilledData

class SkillSelectionViewModel: SkilledData, ValidatableConfigViewModel {
    private val skills = SkillsData(mutableMapOf())
    private var usedSkillPoints = 0
    private val validator: SkillValidator = SkillValidator(this)

    fun addSkillPoint(skill : Skill) {
        //Log.d("SSVM", "Adding: ${usedSkillPoints} + 1 = ${usedSkillPoints + 1}")
        if (usedSkillPoints < MAX_SKILL_POINTS) {
            skills.addPoint(skill)
            usedSkillPoints++
        }
    }

    fun removeSkillPoint(skill : Skill) {
        //Log.d("SSVM", "Removing: ${usedSkillPoints} - 1 = ${usedSkillPoints - 1}")
        if (usedSkillPoints > 0 && skills.skillsMap[skill]!! > 0) {
            skills.removePoint(skill)
            usedSkillPoints--
        }
    }

    fun getPointsLeft() : Int {
        return MAX_SKILL_POINTS - usedSkillPoints
    }

    fun getSkillPoints(skill : Skill) : Int {
        Log.d("SSVM", "Getting ${skills.skillsMap[skill]} points for $skill")
        return skills.skillsMap[skill]!!
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