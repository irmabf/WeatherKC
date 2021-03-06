package com.example.irmablanco.weatherapp.fragment

import android.app.Activity
import android.support.v4.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.view.*
import com.example.irmablanco.weatherapp.model.Forecast
import com.example.irmablanco.weatherapp.R
import com.example.irmablanco.weatherapp.model.TemperatureUnit
import com.example.irmablanco.weatherapp.activity.SettingsActivity
import com.example.irmablanco.weatherapp.model.City
import kotlinx.android.synthetic.main.fragment_forecast.*


class ForecastFragment: Fragment() {
    //Creo un companion object, que es donde iran las partes estáticas
    //del forecast fragment
    companion object {
        val ARG_CITY = "ARG_CITY"
        /*Metodo para crear instancias de ciudades
        * Recibe una instancia de la data class City y devuelve un Fragmento*/
        fun newInstance(city: City): Fragment{
            //Nos creamos el fragment, que será una nueva instancia de ForecastFragment
            val fragment = ForecastFragment()
            //Nos creamos los argumentos del fragment
            val arguments = Bundle()
            arguments.putSerializable(ARG_CITY, city)
            //Asignamos los argumentos al fragment
            fragment.arguments = arguments
            //Devolvemos  el fragment
            return fragment
        }
    }

    val REQUEST_SETTINGS = 1
    val PREFERENCE_UNITS = "UNITS"

    var forecast: Forecast? = null
        set(value) {
            field = value

            if (value != null) {
                forecast_image.setImageResource(value.icon)
                forecast_description.text = value.description

                updateTemperatureView()
                humidity.text = getString(R.string.humidity_format, value.humidity)
            }
        }

    val units: TemperatureUnit
        get() = when (PreferenceManager.getDefaultSharedPreferences(activity)
                .getInt(PREFERENCE_UNITS, TemperatureUnit.CELSIUS.ordinal)) {
            TemperatureUnit.CELSIUS.ordinal -> TemperatureUnit.CELSIUS
            else -> TemperatureUnit.FAHRENHEIT
        }
    /***************************************onCreate**********************************
    *Metodo onCreate propio de los fragments, su funcion es colocar el menu si lo hay
    *Es un metodo opcional en los fragments puesto que no tiene  nada
    * qué ver con el onCreate de las activitys */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val city = arguments?.getSerializable(ARG_CITY) as City
            forecast = city.forecast
        }
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.menu_show_settings -> {
                //Lanzaremos la pantalla de ajustes, indicando que nos devolverá datos
                startActivityForResult(
                        SettingsActivity.intent(activity!!, units),
                        REQUEST_SETTINGS)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /*Los fragments pueden ser los objectivos de un onActivityResult,
    * es decir, que cuando yo regrese de otra pantalla, en otro caso de ajustes,
    *la clase fragment puede implementar el onActivityResult y por tanto,
     * me puedo enterar en un fragment que estoy volviendo de una pantalla*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_SETTINGS -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    // Volvemos de settings con datos sobre las unidades elegidas por el usuario
                    val newUnits = data.getSerializableExtra(SettingsActivity.EXTRA_UNITS) as TemperatureUnit
                    val oldUnits = units

                    //Guardamos las preferencias del usuario en cuanto a Celsius o Fahrenheit
                    //Ojo!! Con esto guardamos los datos, pero los tenemos que recuperar en onCreate
                    PreferenceManager.getDefaultSharedPreferences(activity)
                            .edit()
                            .putInt(PREFERENCE_UNITS, newUnits.ordinal)
                            .apply()

                    // Actualizo la interfaz con las nuevas unidades
                    updateTemperatureView()

                    val newUnitsString = if (newUnits == TemperatureUnit.CELSIUS) getString(R.string.user_selects_celsius)
                    else getString(R.string.user_selects_fahrenheit)
                    //Toast.makeText(this, newUnitsString, Toast.LENGTH_LONG).show()
                    Snackbar.make(view!!, newUnitsString, Snackbar.LENGTH_LONG)
                            //.setAction(getString(R.string.undo), View.OnClickListener {
                            .setAction(getString(R.string.undo)){
                                //Guardo las unidades viejas
                                PreferenceManager.getDefaultSharedPreferences(activity)
                                        .edit()
                                        .putInt(PREFERENCE_UNITS, oldUnits.ordinal)
                                        .apply()
                                updateTemperatureView()
                                //Actualizo la interfaz para restaurar las unidades viejas
                            }
                            .show()
                }
            }
        }
    }


    // Aquí actualizaremos la interfaz con las temperaturas
    fun updateTemperatureView() {
        val unitsString = unitsToSring()
        max_temp.text = getString(R.string.max_temp_format, forecast?.getMaxTemp(units), unitsString)
        min_temp.text = getString(R.string.min_temp_format, forecast?.getMinTemp(units), unitsString)
    }

    fun unitsToSring() = if (units == TemperatureUnit.CELSIUS) "ºC"
    else "F"

}