package com.saritzia.ej2feedbacku2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.saritzia.ej2feedbacku2.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        country = (intent.extras?.getSerializable("country") ?: Country("",0)) as Country
        binding.countryText.text = "País: ${country.countryName}"
        binding.populationText.text = "Población: ${country.population}"
        setFlag()
    }

    private fun setFlag() {
        when {
            country.countryName.equals("argentina",true) -> binding.imageView.setImageResource(R.drawable.argentine)
            country.countryName.equals("usa",true) -> binding.imageView.setImageResource(R.drawable.eeuu)
            country.countryName.equals("francia",true) -> binding.imageView.setImageResource(R.drawable.france)
            country.countryName.equals("holanda",true) -> binding.imageView.setImageResource(R.drawable.holland)
            country.countryName.equals("irlanda",true) -> binding.imageView.setImageResource(R.drawable.ireland)
            country.countryName.equals("italia",true) -> binding.imageView.setImageResource(R.drawable.italy)
            country.countryName.equals("japon",true) -> binding.imageView.setImageResource(R.drawable.japan)
            country.countryName.equals("marruecos",true) -> binding.imageView.setImageResource(R.drawable.morocco)
            country.countryName.equals("portugal",true) -> binding.imageView.setImageResource(R.drawable.portugal)
            country.countryName.equals("españa",true) -> binding.imageView.setImageResource(R.drawable.spain)
            else -> binding.imageView.setImageResource(R.drawable.default_image)
        }
    }

}