package edu.gatech.cs2340.spacetrader.model.saving.database

import android.content.Context
import android.database.sqlite.SQLiteException
import android.util.Log
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.saving.Savable
import edu.gatech.cs2340.spacetrader.util.Size
import java.lang.Exception

class DatabaseSave(context: Context, val name:String): Savable{
    val db = DatabaseHandler(context)

    override fun save(manager: GameManager, size: Size?, context: Context): Boolean {
        return try {
            context.deleteDatabase("saveData")
            db.updatePlayer(GameManager.INSTANCE!!.player, GameManager.INSTANCE!!.difficulty, size!!)
            db.updateUniverse(GameManager.INSTANCE!!.universe, GameManager.INSTANCE!!.player, GameManager.INSTANCE!!.currentPlanet)
            true
        } catch(e: Exception) {
            Log.d("sql error", e.toString())
            false
        }
    } //save

    override fun load(context: Context): Boolean {
        //return try{
            GameManager.SIZE = db.readSize(name)
            GameManager.INSTANCE = db.readGame(name)

            Log.d("load", "load successful")
            return true
//        } catch(e: SQLiteException) {
//            Log.d("sql error", e.toString())
//            false
//        }
    }

} //DatabaseSave