package edu.gatech.cs2340.spacetrader.model.encounter

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import edu.gatech.cs2340.spacetrader.R

abstract class EncounterPopUp(private val view: AppCompatActivity, private val title: String) {
    private var window: PopupWindow? = null

    abstract fun onAttackClicked(window: PopupWindow)

    abstract fun onFleeClicked(window: PopupWindow)

    abstract fun onSurrenderClicked(window: PopupWindow)

    abstract fun getDescription(): String

    fun display() {
        val inflater = view.layoutInflater
        val statusView = inflater.inflate(R.layout.popup_encounter, null)

        val popUpWindow = PopupWindow( statusView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        if ( Build.VERSION.SDK_INT >= 21 ){
            popUpWindow.elevation = 5.0f
        }

        val attackButton = statusView.findViewById<Button>( R.id.button1 )
        val fleeButton = statusView.findViewById<Button>( R.id.button2 )
        val surrenderButton = statusView.findViewById<Button>( R.id.button3 )

        attackButton.setOnClickListener {
            onAttackClicked( popUpWindow )
        }

        fleeButton.setOnClickListener {
            onFleeClicked( popUpWindow )
        }

        surrenderButton.setOnClickListener {
            onSurrenderClicked( popUpWindow )
        }

        val title = statusView.findViewById<TextView>( R.id.title )
        val desc = statusView.findViewById<TextView>( R.id.description )

        title.text = this.title
        desc.text = getDescription()

        popUpWindow.showAtLocation( statusView, Gravity.CENTER, 0, 0 )

        window = popUpWindow
    }

    fun setFinalDisplay(description: String) {
        val statusView = window!!.contentView

        val button1 = statusView.findViewById<Button>( R.id.button1 )
        val button2 = statusView.findViewById<Button>( R.id.button2 )
        val button3 = statusView.findViewById<Button>( R.id.button3 )

        button1.visibility = View.GONE
        button3.visibility = View.GONE

        button2.text = "Close"
        button2.setOnClickListener {
            window!!.dismiss()
        }

        val desc = statusView.findViewById<TextView>( R.id.description )

        desc.text = description
    }
}