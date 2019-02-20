package edu.gatech.cs2340.spacetrader.viewmodel

import edu.gatech.cs2340.spacetrader.model.GameDifficulty


class GameDifficultyViewModel {
    private var difficulty = GameDifficulty.NORMAL

    fun getDifficulty():GameDifficulty {
        return difficulty
    }

    fun setDifficulty(difficulty: GameDifficulty) {
        this.difficulty = difficulty
    }

}
