package edu.gatech.cs2340.spacetrader.viewmodel

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.saving.Savable
import edu.gatech.cs2340.spacetrader.model.saving.SerialSave

class PlanetMenuViewModel(private val view: AppCompatActivity) {
    fun save() {
        val saver: Savable = SerialSave()
        val result = if(saver.save(GameManager.INSTANCE!!, GameManager.SIZE,view.applicationContext)) {
            "Save Successful"
        } else {
            "Save failed, try again later"
        }
        Toast.makeText(view, result, Toast.LENGTH_SHORT).show()
    } //saveButton listener
} //PlanetMenuViewModel