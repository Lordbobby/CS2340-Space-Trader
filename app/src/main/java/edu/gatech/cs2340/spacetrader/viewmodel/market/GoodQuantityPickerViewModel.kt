package edu.gatech.cs2340.spacetrader.viewmodel.market

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import edu.gatech.cs2340.spacetrader.entity.Good
import edu.gatech.cs2340.spacetrader.model.transaction.Transactional

class GoodQuantityPickerViewModel(val dialog: Dialog, val activity: AppCompatActivity){
    fun confirmTransaction(good: Good, quantity: Int, transactional: Transactional) {
        transactional.performTransaction(good, quantity, activity)
        dialog.dismiss()
    } //confirmTransaction
} //GoodQuantityPickerViewModel