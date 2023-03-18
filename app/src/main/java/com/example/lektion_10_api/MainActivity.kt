/** Läraren **/
package com.example.lektion_10_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout.Metrics
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lektion_10_api.api.Fox
import com.example.lektion_10_api.api.FoxApi
import com.example.lektion_10_api.databinding.ActivityMainBinding
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Id's
        val tvFox = binding.tvFoxApi
        val ivFox = binding.ivFox

        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomfox.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val randomFox = retrofit.create<FoxApi>().getRandomFox()

        randomFox.enqueue(object : Callback<Fox> {
            override fun onResponse(call: Call<Fox>, response: Response<Fox>) {

                // Status code 200 - 300
                if (response.isSuccessful) {
                    val fox = response.body()

                    // Is FOX NOT null?
                    if (fox != null) {
                        tvFox.text = fox.myImage

                        // Load Image
                        Glide.with(binding.root)
                            .load(fox.myImage)
                            .apply(RequestOptions.overrideOf(450))
                            .into(ivFox)


                    }

                } else {
                    println("ERROR")
                }

            }

            override fun onFailure(call: Call<Fox>, t: Throwable) {
                // ERROR + 404 Not found
                // ERROR + No Internet Connection
                println(t.printStackTrace())
            }

        })

    }
}