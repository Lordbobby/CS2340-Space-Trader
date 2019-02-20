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
import edu.gatech.cs2340.spacetrader.viewmodel.NameSelectionViewModel
import edu.gatech.cs2340.spacetrader.viewmodel.SkillSelectionViewModel
import kotlinx.android.synthetic.main.fragment_name_selection.*
import kotlinx.android.synthetic.main.fragment_name_selection.view.*
import kotlinx.android.synthetic.main.fragment_skill_selection.view.*
import java.util.jar.Attributes

class NameFragment : Fragment() {
    val nameVm = NameSelectionViewModel()

    companion object {
        fun newInstance(): NameFragment {
            return NameFragment()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = view.name_input

        fun updateName() {
            name.setText(nameVm.getName())
        }

        updateName()
    }


}