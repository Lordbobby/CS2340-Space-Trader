package edu.gatech.cs2340.spacetrader.viewmodel.market

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.views.market.MarketMode

class  GoodQuantityPickerViewModel(val dialog: Dialog, val activity: AppCompatActivity){
    fun confirmTransaction(good: Good, quantity: Int, mode:MarketMode) {
        if(MarketMode.BUY == mode) {
            buy(good, quantity)
        } else {
            sell(good, quantity)
        }
        dialog.dismiss()
    } //confirmTransaction

    private fun buy(good: Good, quantity: Int) {
        val total = quantity * good.price(GameManager.INSTANCE!!.currentPlanet)
        val playerBalance = GameManager.INSTANCE!!.player.credits
        when {
            total > playerBalance -> Toast.makeText(activity, "Not enough credits!", Toast.LENGTH_SHORT).show()
            quantity + GameManager.INSTANCE!!.player.ship.inventory.size > GameManager.INSTANCE!!.player.ship.inventory.cap ->
                Toast.makeText(activity, "Not enough cargo space!", Toast.LENGTH_SHORT).show()
            else -> {
                Log.d("player inventory", GameManager.INSTANCE!!.player.ship.inventory.toString())
                GameManager.INSTANCE!!.player.ship.inventory.addToInv(good, quantity)
                Log.d("player inventory", GameManager.INSTANCE!!.player.ship.inventory.toString())
                GameManager.INSTANCE!!.currentPlanet.inventory.removeFromInv(good, quantity)
                GameManager.INSTANCE!!.player.credits = playerBalance - total
            }
        } //if total exceeds player money
    } //buy

    private fun sell(good: Good, quantity: Int) {
        val total = quantity * good.price(GameManager.INSTANCE!!.currentPlanet)
        val playerBalance = GameManager.INSTANCE!!.player.credits
        
        Log.d("selling", "variables initialised")
        GameManager.INSTANCE!!.player.ship.inventory.removeFromInv(good, quantity)
        GameManager.INSTANCE!!.currentPlanet.inventory.addToInv(good, quantity)
        GameManager.INSTANCE!!.player.credits = playerBalance + total
    } //sell

} //GoodQuantityPickerViewModel