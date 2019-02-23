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
import kotlinx.android.synthetic.main.activity_universe_map.*
import org.w3c.dom.Text


class UniverseMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universe_map)
        var gridLayout: GridLayout = findViewById(R.id.universe_gridlayout)

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
                val textView= AppCompatTextView(this)
//                var params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(1, 1)
//                textView.setLayoutParams(params)
                for (coord in coordArray) {
                    if (coord.hashCode() == Coordinate(c, r).hashCode()) {
                        textView.setText("X")
                    } else  if (c == 1 || r == 1 || c == 25 || r == 25){
                        textView.setText("~")
                    } else {
                        textView.setText("")
                    }
                }
                gridLayout.addView(textView, gridParam)
            }
        }
    }
}
