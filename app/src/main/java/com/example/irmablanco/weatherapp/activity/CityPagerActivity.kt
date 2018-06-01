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
