package edu.gatech.cs2340.spacetrader.viewmodel

import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.GridLayout
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.generators.MapGenerator
import edu.gatech.cs2340.spacetrader.model.GameManager

class UniverseMapViewModel(private val view: AppCompatActivity) {

    fun populateGridLayout(gridLayout: GridLayout) {
        gridLayout.removeAllViews()

        val column = 25
        val row = 25
        gridLayout.columnCount = column
        gridLayout.rowCount = row

        val center = GameManager.INSTANCE!!.currentPlanet
        val gen = MapGenerator(GameManager.INSTANCE!!, center.coordinate, row, column)
        val map = gen.generate()

        for (c in 0 until column) {
            for (r in 0 until row) {
                val textView = TextView(view)

                gridLayout.addView(textView)
                textView.layoutParams = getLayoutParams(r, c)
            }
        }

        map.forEach {
            val textView = gridLayout.getChildAt(getIndex(it.key.x, it.key.y)) as TextView

            textView.text = "X"
        }
    }


    private fun getLayoutParams(row: Int, col: Int): GridLayout.LayoutParams {
        val param = GridLayout.LayoutParams()

        param.height = GridLayout.LayoutParams.WRAP_CONTENT
        param.width = GridLayout.LayoutParams.WRAP_CONTENT
        param.rightMargin = 20
        param.topMargin = 20
        param.setGravity(Gravity.CENTER)
        param.columnSpec = GridLayout.spec(col)
        param.rowSpec = GridLayout.spec(row)

        return param
    }

    private fun getIndex(row: Int, col: Int): Int {
        return col + (row - 1) * 25
    }
}