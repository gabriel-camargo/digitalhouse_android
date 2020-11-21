package com.gabrielcamargo.chucknorrisapi.categories.repository

import com.gabrielcamargo.chucknorrisapi.data.api.NetworkUtils
import retrofit2.http.GET

interface CategoriesEndpoint {

    @GET("categories")
    suspend fun get(): List<String>

    companion object {
        val endpoint: CategoriesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoriesEndpoint::class.java)
        }
    }
}
