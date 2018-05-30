package com.example.irmablanco.weatherapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    //Creamos un metodo estatico con el intent que usaremos desde ForecastActivity para llamar a la pantalla de SettingsActivity
    companion object {
        fun intent(context: Context): Intent{
            val intent = Intent(context, SettingsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        ok_btn.setOnClickListener{ acceptSettings() }
        cancel_btn.setOnClickListener{ cancelSettings() }
        //show celsius btn as preselected btn in btn group
        units_rg.check(R.id.celsius_rb)
    }

    private fun cancelSettings() {
        //Go back to previous activity
        finish()
    }

    private fun acceptSettings() {
        //Go back to previous activity
        finish()
    }
}
