package edu.gatech.cs2340.spacetrader.viewmodel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.saving.Savable
import edu.gatech.cs2340.spacetrader.model.saving.SerialSave
import edu.gatech.cs2340.spacetrader.model.saving.database.DatabaseSave
import edu.gatech.cs2340.spacetrader.views.UniverseMapActivity

class MainMenuViewModel(private val view: AppCompatActivity) {
    fun load() {
        val saver: Savable = SerialSave()
        val result:String
        result = if(saver.load(view)) {
            "Load successful"
        } else {
            "Load failed, try again later"
        } //if saver failed or not

        val intent = Intent(view, UniverseMapActivity::class.java)
        view.startActivity(intent)

        Toast.makeText(view, result, Toast.LENGTH_SHORT).show()
    } //load

    fun loadDb() {
        val saver: Savable = DatabaseSave(view, "angelo")
        val result:String
        result = if(saver.load(view)) {
            "Load successful"
        } else {
            "Load failed, try again later"
        } //if saver failed or not
        Log.d("aah", GameManager.INSTANCE!!.currentPlanet.name)

        val intent = Intent(view, UniverseMapActivity::class.java)
        view.startActivity(intent)

        Toast.makeText(view, result, Toast.LENGTH_SHORT).show()
    }




} //MainMenuViewModel