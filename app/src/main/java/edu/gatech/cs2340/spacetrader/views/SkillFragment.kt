package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.gatech.cs2340.spacetrader.R

class SkillFragment : Fragment() {

    companion object {
        fun newInstance(): SkillFragment {
            return SkillFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill_selection, container, false)
    }
}