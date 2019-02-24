package edu.gatech.cs2340.spacetrader.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.viewmodel.UniverseMapViewModel


class UniverseMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universe_map)
        val universeMap: UniverseMapViewModel = UniverseMapViewModel(this,findViewById(R.id.universe_gridlayout))
        universeMap.populateMap()
        universeMap.drawRange()

    }
}
