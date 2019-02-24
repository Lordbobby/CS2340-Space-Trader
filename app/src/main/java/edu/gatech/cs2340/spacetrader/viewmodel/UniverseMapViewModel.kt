package edu.gatech.cs2340.spacetrader.viewmodel

import android.support.v7.widget.GridLayout
import android.util.Log
import android.widget.Button
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.util.Coordinate
import edu.gatech.cs2340.spacetrader.views.UniverseMapActivity


class UniverseMapViewModel(val activity: UniverseMapActivity, val gridLayout: GridLayout) {

    fun populateMap() {
        gridLayout.removeAllViews()

        val column = 25
        val row = 25
        val coordArray: Array<Coordinate> = arrayOf(Coordinate(1, 2), Coordinate(3, 4))
        gridLayout.setColumnCount(column)
        gridLayout.setRowCount(row)
        for (c in 1..column) {
            for (r in 1..row) {
                var rowSpan: GridLayout.Spec = GridLayout.spec(GridLayout.UNDEFINED, 1)
                var colSpan: GridLayout.Spec = GridLayout.spec(GridLayout.UNDEFINED, 1)
                var gridParam: GridLayout.LayoutParams = GridLayout.LayoutParams(rowSpan, colSpan)
//                gridParam.setGravity(1)
                if (coordArray.contains(Coordinate(r, c))) {
                    val btnTag: Button = Button(activity)
                    btnTag.setText("Button $c, $r")
                    btnTag.setId(Coordinate(r, c).hashCode())
                    gridLayout.addView(btnTag, gridParam)
                } else  if (c == 1 || r == 1 || c == 25 || r == 25){
                    val textView = TextView(activity)
                    textView.setText("~")
                    gridLayout.addView(textView, gridParam)
                } else {
                    val textView = TextView(activity)
                    textView.setText("")
                    gridLayout.addView(textView, gridParam)
                }
            }
        }
    }

    fun drawRange() {
        val currPlanetHash = Coordinate(3, 4).hashCode()
        val currPlanetBtn = gridLayout.findViewById<Button>(currPlanetHash)
        currPlanetBtn.setBackgroundResource(R.drawable.range_ring)
    }
}