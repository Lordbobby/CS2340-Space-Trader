package edu.gatech.cs2340.spacetrader.views

import android.app.ActionBar
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.GridLayout
import android.support.v7.widget.GridLayoutManager
import android.text.Layout
import android.view.ViewGroup
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.util.Coordinate
import edu.gatech.cs2340.spacetrader.viewmodel.UniverseMapViewModel
import kotlinx.android.synthetic.main.activity_universe_map.*
import org.w3c.dom.Text


class UniverseMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universe_map)
        var gridLayout: GridLayout = findViewById(R.id.universe_gridlayout)
        val umvm: UniverseMapViewModel = UniverseMapViewModel(this, gridLayout)
    }
}
