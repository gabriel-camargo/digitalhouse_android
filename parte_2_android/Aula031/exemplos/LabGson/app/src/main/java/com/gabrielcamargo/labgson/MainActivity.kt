package com.gabrielcamargo.labgson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gabrielcamargo.labgson.model.ApiResponseModel
import com.gabrielcamargo.labgson.model.CharacterModel
import com.gabrielcamargo.labgson.model.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        httpClient = NetworkUtils.getRetrofitInstance(BASE_URL)
        obterLocalizacao()
    }

    fun obterPersonagens() {
        var endpoint = httpClient.create(IEndPoint::class.java)

        endpoint.obterPersonagens().enqueue(object: Callback<ApiResponseModel<CharacterModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<CharacterModel>>,
                response: Response<ApiResponseModel<CharacterModel>>
            ) {
                val resultado = response.body()
                Toast.makeText(this@MainActivity, resultado!!.results[1].nome, Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ApiResponseModel<CharacterModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun obterLocalizacao() {
        var endpoint = httpClient.create(IEndPoint::class.java)

        endpoint.obterLocalizacao().enqueue(object: Callback<ApiResponseModel<LocationModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<LocationModel>>,
                response: Response<ApiResponseModel<LocationModel>>
            ) {
                val resultado = response.body()
                Toast.makeText(this@MainActivity, resultado!!.results[5].nome, Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<ApiResponseModel<LocationModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        lateinit var httpClient: Retrofit
    }
}