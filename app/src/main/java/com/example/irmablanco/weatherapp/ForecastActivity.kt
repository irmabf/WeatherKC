package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : AppCompatActivity(){
    val TAG = ForecastActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        val forecast = Forecast(
                25f,
                10f,
                35f,
                "Soleado con alguna nube",
                R.drawable.ico_01)

    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putInt("Numero", 3)
    }

}
