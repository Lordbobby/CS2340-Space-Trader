package edu.gatech.cs2340.spacetrader.model.saving

import android.content.Context
import android.util.Log
import edu.gatech.cs2340.spacetrader.model.GameManager
import java.io.*

class SerialSave: Savable {
    private val saveFileName = "saveFile"

    override fun save(manager: GameManager, context: Context): Boolean {
        try{
            val fileOutput = context.openFileOutput(saveFileName, Context.MODE_PRIVATE)
            val objectOutput = ObjectOutputStream(fileOutput)

            objectOutput.writeObject(manager)
            objectOutput.close()
            fileOutput.close()


            Log.d("save", "save successful")
            return true;
        } catch(e: IOException) {
            Log.d("save", e.toString())
        } //try to save
        return false;
    } //save

    override fun load(context: Context):Boolean {
        var manager:GameManager?

        try {
            val fileInput = context.openFileInput(saveFileName)
            val objectInput = ObjectInputStream(fileInput)

            manager = objectInput.readObject() as GameManager
            objectInput.close()
            fileInput.close()
            GameManager.INSTANCE = manager
            Log.d("load", "load successful")
            return true
        } catch(e: IOException) {
            Log.d("load", e.toString())
        } //try to load
        return false
    } //load
} //SerialSave