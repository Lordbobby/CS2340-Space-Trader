package edu.gatech.cs2340.spacetrader.model.saving

import android.util.Log
import edu.gatech.cs2340.spacetrader.model.GameManager
import java.io.*

class SerialSave: Savable {
    private val saveFileName = "saveFile"

    override fun save(manager: GameManager) {
        try{
            val fileOutput = FileOutputStream(saveFileName)
            val objectOutput = ObjectOutputStream(fileOutput)

            objectOutput.writeObject(manager)
            objectOutput.close()
            fileOutput.close()

        } catch(e: IOException) {
            Log.d("save", e.toString())
        } //try to save

        Log.d("save", "save successful")
    } //save

    override fun load():GameManager? {
        var manager:GameManager? = null

        try {
            val fileInput = FileInputStream(saveFileName)
            val objectInput = ObjectInputStream(fileInput)

            manager = objectInput.readObject() as GameManager
            objectInput.close()
            fileInput.close()
        } catch(e: IOException) {
            Log.d("load", e.toString())
        } //try to load

        Log.d("load", "load successvul")

        return manager
    } //load
} //SerialSave