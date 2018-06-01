package com.example.irmablanco.weatherapp.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.example.irmablanco.weatherapp.R
import com.example.irmablanco.weatherapp.fragment.ForecastFragment
import com.example.irmablanco.weatherapp.model.Cities
import kotlinx.android.synthetic.main.activity_city_pager.*

class CityPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_pager)

        /**Decimos a la action bar cual es la toolbar que queremos que se use en nuestra app
         * Qué vista es la que queremos que haga de toolbar, lo debemos decir con findViewById
         * o con una kotlin extension como hacemos en este caso.
         * ****Recordamos que en activity_city_pager hemos dado al widget toolbar un id de toolbar y esto es lo
         * que pasamos
         *
         * Tambien vamos a cambiar el logo a la toolbar*/
        toolbar.setLogo(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)

        val cities = Cities()
        //Creo el adaptador
        val adapter = object: FragmentPagerAdapter(supportFragmentManager){

            override fun getItem(position: Int): Fragment {
                return ForecastFragment.newInstance(cities.getCity(position))
            }
            /*override fun getCount(): Int {
                return cities.count
            }*/
            override fun getCount() = cities.count

            override fun getPageTitle(position: Int): CharSequence? {
                return cities.getCity(position).name
            }
        }
        //Paso el adaptador al fragment
        //Ojo!! Vamos a android manifest a informar de que esta es la priemra pantalla
        view_pager.adapter = adapter
    }
}
