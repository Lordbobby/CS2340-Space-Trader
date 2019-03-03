package edu.gatech.cs2340.spacetrader.views.market

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.entity.inventory.Inventory
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.viewmodel.MarketViewModel
import kotlinx.android.synthetic.main.activity_market.*

class MarketActivity: AppCompatActivity() {
    val viewModel = MarketViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)
        val mode =  intent.getSerializableExtra("mode")
        market_label.text = mode.toString()
        val inventory: Inventory
        if(mode == MarketMode.BUY) {

        } else {

        }

        viewModel.populateMarketList(good_list)
    } //onCreate

} //MarketActivity