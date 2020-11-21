package com.gabrielcamargo.chucknorrisapi.jokes.repository

import com.gabrielcamargo.chucknorrisapi.data.api.NetworkUtils
import com.gabrielcamargo.chucknorrisapi.jokes.model.JokeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeEndpoint {
    @GET("random")
    suspend fun get(@Query("category") category: String?): JokeModel

    companion object {
        val endpoint: JokeEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(JokeEndpoint::class.java)
        }
    }
}
