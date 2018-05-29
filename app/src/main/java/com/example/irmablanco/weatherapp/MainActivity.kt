package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = MainActivity::class.java.canonicalName
    var forecastImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        //C
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val europeanButton = findViewById<Button>(R.id.european_system_button)
        val americanButton = findViewById<Button>(R.id.american_system_button)
        forecastImage = findViewById(R.id.forecast_image)

        europeanButton?.setOnClickListener(this)
        americanButton?.setOnClickListener(this)

    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putInt("Numero", 3)
    }

    override fun onClick(v: View?) {
        /*Log.v(TAG, when (v?.id){
            R.id.european_system_button ->  "Han pulsado el boton europeo"
            R.id.american_system_button -> "Han pulsado el boton americano"
            else -> "No se lo que han pulsado"
        })*/
        val imageToShow = when (v?.id){
            R.id.european_system_button -> R.drawable.offline_weather
            else -> R.drawable.offline_weather2
        }
        forecastImage?.setImageResource(imageToShow)
    }
}
