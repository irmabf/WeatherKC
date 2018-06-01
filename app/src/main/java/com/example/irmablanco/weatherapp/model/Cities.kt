package com.example.irmablanco.weatherapp.model

import com.example.irmablanco.weatherapp.R

class Cities {
    private val cities: List<City> = listOf(
            City("Madrid", Forecast(25f, 10f, 35f, "Soleado con alguna nube", R.drawable.ico_02)),
            City("Barcelona", Forecast(35f, 14f, 30f, "Soleado sin nubes", R.drawable.ico_01)),
            City("Bilbao", Forecast(20f, 7f, 40f, "Nuboso con llovizna", R.drawable.ico_10))
    )

    val count
        get() = cities.size

    fun getCity(index: Int) = cities[index]
}