package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameDifficulty
import edu.gatech.cs2340.spacetrader.viewmodel.GameDifficultyViewModel
import kotlinx.android.synthetic.main.fragment_game_difficulty.*

class GameDifficultyFragment : Fragment(){
    val difficultyVM = GameDifficultyViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_game_difficulty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ArrayAdapter<GameDifficulty>(activity, android.R.layout.simple_spinner_item, GameDifficulty.values())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gameDifficultySpinner!!.adapter = adapter
    }

}
