package com.example.irmablanco.weatherapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    //Creamos un metodo estatico con el intent que usaremos desde ForecastActivity para llamar a la pantalla de SettingsActivity
    companion object {
        //Damos  un valor a la key para las initial Units
        val EXTRA_UNITS = "EXTRA_UNITS"
        fun intent(context: Context, initialUnits: TemperatureUnit): Intent{
            val intent = Intent(context, SettingsActivity::class.java)

           intent.putExtra(EXTRA_UNITS, initialUnits)
            return intent
        }
    }

    //Recuperamos las initialUnits con by lazy
    val initialUnits by lazy{
        intent.getSerializableExtra(EXTRA_UNITS)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        ok_btn.setOnClickListener{ acceptSettings() }
        cancel_btn.setOnClickListener{ cancelSettings() }
        //show celsius btn as preselected btn in btn group
        //Decidir que radioButton debe estar marcado en funcion de initialUnits

        units_rg.check(if (initialUnits == TemperatureUnit.CELSIUS)
            R.id.celsius_rb
            else R.id.farenheit_rb
        )
       /* if (initialUnits == TemperatureUnit.CELSIUS){
            units_rg.check(R.id.celsius_rb)
        }else{
            units_rg.check(R.id.farenheit_rb)
        }*/
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
