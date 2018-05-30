package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlin.math.min

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

        setForecast(forecast)
    }
    fun setForecast(forecast: Forecast){
        forecast_image.setImageResource(forecast.icon)
        forecast_description.text = forecast.description
        max_temp.text = getString(R.string.max_temp_format, forecast.maxTemp)
        min_temp.text = getString(R.string.min_temp_format, forecast.minTemp)
        humidity.text = getString(R.string.humidity_format, forecast.humidity)
    }
}
