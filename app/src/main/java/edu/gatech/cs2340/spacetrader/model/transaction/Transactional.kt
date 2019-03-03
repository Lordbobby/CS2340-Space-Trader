package edu.gatech.cs2340.spacetrader.model.transaction

import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.entity.Good

interface Transactional {

    fun performTransaction(good: Good, amount: Int, activity: AppCompatActivity)

    fun mode(): String
}