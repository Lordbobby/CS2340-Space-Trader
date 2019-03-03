package edu.gatech.cs2340.spacetrader.views.market

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.viewmodel.market.GoodQuantityPickerViewModel
import kotlinx.android.synthetic.main.dialog_good_quantity.*

class GoodQuantityPickerDialog(private val activity: AppCompatActivity, val good: Good, val quantity: Int, val mode: MarketMode): Dialog(activity) {
    val viewModel = GoodQuantityPickerViewModel(this, activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_good_quantity)
        quantity_picker.maxValue = quantity

        cancel_button.setOnClickListener{
            dismiss()
        } //cancel button set click listener

        confirm_button.setOnClickListener{
            viewModel.confirmTransaction(good, quantity_picker.value, mode)

            //updates the information on the screen
            val oldIntent = activity.intent
            activity.finish()
            activity.startActivity(oldIntent)
        } //confirm button set click listener

    } //onCreate
} //GoodQuantityPickerDialog