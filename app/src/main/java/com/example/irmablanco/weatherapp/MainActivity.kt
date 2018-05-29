package com.example.irmablanco.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(){
    val TAG = MainActivity::class.java.canonicalName
    val forecastImage by lazy {
        findViewById<ImageView>(R.id.forecast_image)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val europeanButton = findViewById<Button>(R.id.european_system_button)
        val americanButton = findViewById<Button>(R.id.american_system_button)

        europeanButton?.setOnClickListener {
            forecastImage.setImageResource(R.drawable.offline_weather)
        }
        americanButton?.setOnClickListener{
            forecastImage.setImageResource(R.drawable.offline_weather2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putInt("Numero", 3)
    }

}
