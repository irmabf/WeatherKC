package com.example.irmablanco.weatherapp

//Usamos un enum para guardar en grados celsius y en grados fahrenheit
//Lo pasamos a SettingsActivity
enum class TemperatureUnit{
    CELSIUS,
    FAHRENHEIT
}
data class Forecast (val maxTemp: Float, val minTemp: Float, val humidity: Float, val description: String, val icon: Int) {


}