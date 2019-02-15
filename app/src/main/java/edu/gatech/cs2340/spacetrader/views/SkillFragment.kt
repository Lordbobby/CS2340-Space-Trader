package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.Skill
import edu.gatech.cs2340.spacetrader.viewmodel.SkillSelectionViewModel
import kotlinx.android.synthetic.main.fragment_skill_selection.view.*

class SkillFragment : Fragment() {
    var skillVm = SkillSelectionViewModel()

    companion object {
        fun newInstance(): SkillFragment {
            return SkillFragment()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pointsLeftTextView = view.skill_selection_pointsLeft
        val pointsPilot = view.skill_pilot_value
        val pointsFighter = view.skill_fighter_value
        val pointsTrader = view.skill_trader_value
        val pointsEngineer = view.skill_engineer_value

        fun updateUnassignedPoints() {
            pointsLeftTextView.setText(getString(R.string.skill_selection_pointsLeft)
                    + skillVm.getPointsLeft())
        }

        fun updatePilotPoints() {
            pointsPilot.setText(getString(R.string.skill_points_current)
                    + skillVm.getSkillPoints(Skill.PILOT))
        }

        fun updateFighterPoints() {
            pointsFighter.setText(getString(R.string.skill_points_current)
                    + skillVm.getSkillPoints(Skill.FIGHTER))
        }

        fun updateTraderPoints() {
            pointsTrader.setText(getString(R.string.skill_points_current)
                    + skillVm.getSkillPoints(Skill.TRADER))
        }

        fun updateEngineerPoints() {
            pointsEngineer.setText(getString(R.string.skill_points_current)
                    + skillVm.getSkillPoints(Skill.ENGINEER))
        }

        updateUnassignedPoints()
        updatePilotPoints()
        updateFighterPoints()
        updateTraderPoints()
        updateEngineerPoints()

        view.skill_pilot_minusButton.setOnClickListener {
            skillVm.removeSkillPoint(Skill.PILOT)
            updateUnassignedPoints()
            updatePilotPoints()
        }

        view.skill_pilot_plusButton.setOnClickListener {
            skillVm.addSkillPoint(Skill.PILOT)
            updateUnassignedPoints()
            updatePilotPoints()
        }

        view.skill_fighter_minusButton.setOnClickListener {
            skillVm.removeSkillPoint(Skill.FIGHTER)
            updateUnassignedPoints()
            updateFighterPoints()
        }

        view.skill_fighter_plusButton.setOnClickListener {
            skillVm.addSkillPoint(Skill.FIGHTER)
            updateUnassignedPoints()
            updateFighterPoints()
        }

        view.skill_trader_minusButton.setOnClickListener {
            skillVm.removeSkillPoint(Skill.TRADER)
            updateUnassignedPoints()
            updateTraderPoints()
        }

        view.skill_trader_plusButton.setOnClickListener {
            skillVm.addSkillPoint(Skill.TRADER)
            updateUnassignedPoints()
            updateTraderPoints()
        }

        view.skill_engineer_minusButton.setOnClickListener {
            skillVm.removeSkillPoint(Skill.ENGINEER)
            updateUnassignedPoints()
            updateEngineerPoints()
        }

        view.skill_engineer_plusButton.setOnClickListener {
            skillVm.addSkillPoint(Skill.ENGINEER)
            updateUnassignedPoints()
            updateEngineerPoints()
        }
    }
}