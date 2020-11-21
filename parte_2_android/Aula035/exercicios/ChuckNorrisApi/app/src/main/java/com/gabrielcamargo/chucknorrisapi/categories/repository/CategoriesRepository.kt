package com.gabrielcamargo.chucknorrisapi.categories.repository

import android.content.Context

class CategoriesRepository(private val context: Context) {

    private val client = CategoriesEndpoint.endpoint

    suspend fun getCategories() = client.get()
}
