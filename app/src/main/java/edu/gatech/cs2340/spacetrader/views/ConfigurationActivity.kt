package edu.gatech.cs2340.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.viewmodel.ConfigurationViewModel
import edu.gatech.cs2340.spacetrader.views.interfaces.ConfigViewModelProvider
import kotlinx.android.synthetic.main.activity_configuration.*

class ConfigurationActivity : AppCompatActivity() {
    private val configVM = ConfigurationViewModel()
    private val vmProviders = ArrayList<ConfigViewModelProvider>()

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)

        if(fragment is ConfigViewModelProvider) {
            vmProviders.add(fragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        start_game.setOnClickListener {
            val toastText: String? = configVM.onDataSubmission(vmProviders)

            if (toastText != null) {
                Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            configVM.startGame()
            startActivity(Intent(this, UniverseMapActivity::class.java))
        } //setOnClickListener

        exit_game.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
    } //onCreate
} //ConfigurationActivity
