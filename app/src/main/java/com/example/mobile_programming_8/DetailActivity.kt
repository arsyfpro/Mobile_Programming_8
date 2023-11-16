package com.example.mobile_programming_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mobile_programming_8.data.CountryDetail
import com.example.mobile_programming_8.databinding.ActivityDetailBinding
import com.example.mobile_programming_8.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryId: String = intent.getStringExtra("country_id").toString()

        retrieveCountryDetail(countryId)
    }

    private fun retrieveCountryDetail(countryId: String) {
        RetrofitClient.instance.getCountryDetail(countryId)
            .enqueue(object: Callback<CountryDetail> {
                override fun onResponse(call: Call<CountryDetail>, response: Response<CountryDetail>) {
                    if (response.code() == 200) {
                        val list = response.body()
                        Log.d("GET COUNTRY DETAIL", list.toString())

                        if (list == null) {
                            Toast.makeText(this@DetailActivity, "There is no country data to display", Toast.LENGTH_LONG).show()
                        } else {
                            binding.tvCountryName.text = list.countryName
                            binding.tvCountryArea.text = list.countryArea
                            binding.tvCountryPopulation.text = list.countryPopulation.toString()
                            binding.tvCountryDesc.text = list.countryDescription
                        }
                    } else {
                        Toast.makeText(this@DetailActivity, "Fail fetching from database response is not 200", Toast.LENGTH_LONG).show()
                        Log.d("GET COUNTRY ITEMS FAIL ${response.code()}", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<CountryDetail>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "Fail fetching from database onFailure", Toast.LENGTH_LONG).show()
                    Log.d("GET COUNTRY ITEMS FAIL", t.toString())
                }
            })
    }
}