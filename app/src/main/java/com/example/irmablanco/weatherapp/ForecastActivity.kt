package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class ForecastActivity : AppCompatActivity(){
    val TAG = ForecastActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        european_system_button.setOnClickListener {
            forecast_image.setImageResource(R.drawable.offline_weather)
        }
        american_system_button.setOnClickListener{
            forecast_image.setImageResource(R.drawable.offline_weather2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putInt("Numero", 3)
    }

}
