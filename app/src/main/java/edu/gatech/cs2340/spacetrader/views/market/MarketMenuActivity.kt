package edu.gatech.cs2340.spacetrader.views.market

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.viewmodel.market.MarketMenuViewModel
import kotlinx.android.synthetic.main.activity_market_menu.*

class MarketMenuActivity: AppCompatActivity() {
    private val viewModel = MarketMenuViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_menu)


        buy_button.setOnClickListener{
            startActivity(Intent(this, MarketActivity::class.java).apply {
                putExtra("mode", MarketMode.BUY) })
        } //buy button listener

        sell_button.setOnClickListener{
            startActivity(Intent(this, MarketActivity::class.java).apply {
                putExtra("mode", MarketMode.SELL) })
        } //sell button listener

        leave_button.setOnClickListener{
            this.finish()
        } //leave button listener
    } //onCreate
} //MarketMenu