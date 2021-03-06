package com.example.irmablanco.weatherapp

import com.example.irmablanco.weatherapp.model.Forecast
import com.example.irmablanco.weatherapp.model.TemperatureUnit
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ForecastUnitTest {
    lateinit var  forecast: Forecast

    @Before
    fun setUp(){
        forecast = Forecast(
                25f,
                10f,
                35f,
                "Soleado con alguna nube",
                R.drawable.ico_01)
    }
    @Test
    fun maxTempUnitsConversion_isCorrect(){
        assertEquals(77f, forecast.getMaxTemp(TemperatureUnit.FAHRENHEIT))

    }
    @Test
    fun minTempUnitsConversion_isCorrect(){
        assertEquals(50f, forecast.getMinTemp(TemperatureUnit.FAHRENHEIT))
    }
}