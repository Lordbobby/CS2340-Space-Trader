package edu.gatech.cs2340.spacetrader.viewmodel.market

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.entity.inventory.Inventory
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.model.transaction.TransactionMode
import edu.gatech.cs2340.spacetrader.views.market.GoodQuantityPickerDialog

class MarketViewModel(val activity: AppCompatActivity) {
    fun populateMarketList(linearLayout: LinearLayout, mode: TransactionMode) {
        val inventory: Inventory

        if(mode == TransactionMode.BUY) {
            inventory = GameManager.INSTANCE!!.currentPlanet.inventory
            Log.d("market", "buying ${inventory.inv.size}")
        } else {
            inventory = GameManager.INSTANCE!!.player.ship.inventory
            Log.d("market", "selling ${inventory.inv.size}")
        } //if buying or selling

        inventory.inv.forEach {
            Log.d("market", "${mode} triggered")
            val goodCard = makeGoodCard(it.key, it.value, mode)
            linearLayout.addView(goodCard)
        } //for each item in inventory
    } //populateMarketList

    private fun makeGoodCard(good: Good, quantity: Int, mode: TransactionMode): CardView {
        val goodCard = CardView(activity)
        val cardLinear = LinearLayout(activity)
        val goodName = TextView(activity)
        val goodQuantity = TextView(activity)
        val goodPrice = TextView(activity)


        goodName.text = good.toString()
        goodName.textSize = 25.toFloat()
        goodQuantity.text = "x${quantity}       "
        goodPrice.text = good.price(GameManager.INSTANCE!!.currentPlanet).toString()

        cardLinear.orientation = LinearLayout.HORIZONTAL
        cardLinear.addView(goodName)
        cardLinear.addView(goodQuantity)
        cardLinear.addView(goodPrice)

        goodCard.addView(cardLinear)
        goodCard.setOnClickListener {
            val dialog = GoodQuantityPickerDialog(activity, good, quantity, mode.provide())
            dialog.show()
        } //goodCard click Listener
        return goodCard
    } //makeGoodCard

} //MarketViewModle