package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlin.math.min

class ForecastActivity : AppCompatActivity(){

    companion object {
        val TAG = ForecastActivity::class.java.canonicalName
    }

    var forecast: Forecast? = null
        //Este codigo, el seter, se ejecutara cuandos se actualize la interfaz ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓📌
        set(value) {
            if (value != null){
                forecast_image.setImageResource(value.icon)
                forecast_description.text = value.description
                max_temp.text = getString(R.string.max_temp_format, value.maxTemp)
                min_temp.text = getString(R.string.min_temp_format, value.minTemp)
                humidity.text = getString(R.string.humidity_format, value.humidity)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        //📌↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑Este codigo me setea el var forecast
        forecast = Forecast(
                25f,
                10f,
                35f,
                "Soleado con alguna nube",
                R.drawable.ico_01)

    }

}
