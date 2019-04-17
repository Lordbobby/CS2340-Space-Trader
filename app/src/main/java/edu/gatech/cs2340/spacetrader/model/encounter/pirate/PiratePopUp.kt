package edu.gatech.cs2340.spacetrader.model.encounter.pirate

import android.support.v7.app.AppCompatActivity
import android.widget.PopupWindow
import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.encounter.EncounterPopUp
import kotlin.random.Random

class PiratePopUp(view: AppCompatActivity, title: String = "Pirate Encounter") : EncounterPopUp(view, title) {
    override fun onAttackClicked(window: PopupWindow) {
        if ( Math.random() <= .6f ) {
            plunderPirate()
        } else {
            plunderByPirate()
        }
    }

    override fun onFleeClicked(window: PopupWindow) {
        if ( Math.random() <= .2f ) {
            plunderByPirate()
        } else {
            setFinalDisplay("You successfully fled the pirate!")
        }
    }

    override fun onSurrenderClicked(window: PopupWindow) {
        plunderByPirate()
    }

    override fun getDescription(): String {
        return "You have encountered a pirate while travelling and he has begun attacking your ship! Will you attack, flee, or surrender?!"
    }

    private fun plunderByPirate() {
        val goodsCopy: MutableMap<Good, Int> = GameManager.INSTANCE!!.player.ship.inventory.inv.toMutableMap()

        if ( goodsCopy.isEmpty() ) {
            displayFinalScreen("The pirate plundered your ship and took:", HashMap() )
            return
        }

        val plundered: HashMap<Good, Int> = HashMap()
        val toRemove = Math.max( goodsCopy.size, 4 ) - 1

        for ( i in 1..Random.nextInt( toRemove ) ) {
            val good = goodsCopy.keys.random()

            plundered[good] = 1 + Random.nextInt( goodsCopy[good]!!.minus( 1 ) )
            goodsCopy.remove( good )
        }

        val notRemoved = GameManager.INSTANCE!!.player.ship.inventory.removeAllFromInv( plundered )

        notRemoved.keys.forEach {
            plundered.remove( it )
        }

        displayFinalScreen( "The pirate plundered your ship and took:", plundered )
    }

    private fun plunderPirate() {
        val goods: HashSet<Good> = HashSet()
        val plundered: HashMap<Good, Int> = HashMap()

        goods.addAll( Good.values() )

        for ( i in 1..Random.nextInt( 4 ) ) {
            val good = goods.random()

            goods.remove( good )
            plundered[good] = 1 + Random.nextInt( 4 )
        }

        val notAdded = GameManager.INSTANCE!!.player.ship.inventory.addAllToInv( plundered )

        notAdded.keys.forEach {
            plundered.remove( it )
        }

        displayFinalScreen( "You plundered the pirate and received:", plundered )
    }

    private fun displayFinalScreen(desc: String, plundered: Map<Good, Int>) {
        val builder = StringBuilder( desc )

        builder.append( "\n" )

        for (entry: Map.Entry<Good, Int> in plundered.entries) {
            builder.append( "- " )
            builder.append( entry.key.name )
            builder.append( ": " )
            builder.append( entry.value )
            builder.append( "\n" )
        }

        setFinalDisplay( builder.toString() )
    }
}