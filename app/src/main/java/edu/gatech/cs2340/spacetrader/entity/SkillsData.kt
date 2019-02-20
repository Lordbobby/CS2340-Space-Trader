package edu.gatech.cs2340.spacetrader.entity

data class SkillsData(var pilot: Int, var fighter: Int, var trader: Int, var engineer: Int) {
    override fun toString(): String {
        return "pilot: {$pilot}, fighter: {$fighter}, trader: {$trader}, and engineer: {$engineer}"
    }
}