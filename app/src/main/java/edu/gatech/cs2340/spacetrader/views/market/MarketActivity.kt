package edu.gatech.cs2340.spacetrader.views.market

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.model.GameManager
import edu.gatech.cs2340.spacetrader.viewmodel.market.MarketViewModel
import kotlinx.android.synthetic.main.activity_market.*

class MarketActivity: AppCompatActivity() {
    val viewModel = MarketViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)
        val mode =  intent.getSerializableExtra("mode") as MarketMode
        market_label.text = mode.toString()
        player_balance.text = "Balance: ${GameManager.INSTANCE!!.player.credits}"

        viewModel.populateMarketList(good_list, mode)
    } //onCreate

} //MarketActivity