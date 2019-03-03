package edu.gatech.cs2340.spacetrader.views.market

enum class MarketMode{
    BUY,
    SELL;

    override fun toString(): String {
        return super.toString().toLowerCase().capitalize()
    } //toString
} //MarketMode