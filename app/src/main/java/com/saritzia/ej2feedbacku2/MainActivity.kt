package com.saritzia.ej2feedbacku2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.saritzia.ej2feedbacku2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var countries : ArrayList<Country>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCountries()
        setListAdapter()
        didTapWithShortClick()
        didTapWithLongClick()
    }

    private fun setListAdapter(){
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        binding.listView.adapter = adapter
    }
    private fun setCountries() {
        countries = ArrayList()
        countries.add(Country(getString(R.string.spain),47200000))
        countries.add(Country(getString(R.string.italy),59110000))
        countries.add(Country(getString(R.string.portugal),10330000))
        countries.add(Country(getString(R.string.japan),125400000))
        countries.add(Country(getString(R.string.argentine),45810000))
        countries.add(Country(getString(R.string.france),67750000))
        countries.add(Country(getString(R.string.usa),331900000))
        countries.add(Country(getString(R.string.morocco),37080000))
        countries.add(Country(getString(R.string.holland),17530000))
        countries.add(Country(getString(R.string.ireland),5033000))
    }

    private fun didTapWithShortClick() {
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val country = countries[position]
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("country",country)
            startActivity(intent)
        }
    }

    private fun didTapWithLongClick() {
        binding.listView.onItemLongClickListener = OnItemLongClickListener { _, _, position, _ ->
                binding.textView.text = countries[position].countryName
            true
            }
    }
}