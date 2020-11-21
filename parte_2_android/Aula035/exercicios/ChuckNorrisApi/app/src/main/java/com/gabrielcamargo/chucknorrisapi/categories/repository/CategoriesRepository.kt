package com.gabrielcamargo.chucknorrisapi.categories.repository

class CategoriesRepository() {

    private val client = CategoriesEndpoint.endpoint

    suspend fun getCategories() = client.get()
}
