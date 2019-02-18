package edu.gatech.cs2340.spacetrader.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner

import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameDifficulty
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_game_difficulty.*

class GameDifficultyFragment : Fragment() {
     private var spinner: Spinner? = null
     // var list_of_items = arrayOf("Beginner", "Easy", "Normal" , "Hard", "Impossible"")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = ArrayAdapter<GameDifficulty>(activity, android.R.layout.simple_spinner_item, GameDifficulty.values())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gameDifficultySpinner.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_difficulty, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameDifficultyFragment()
    }
}
