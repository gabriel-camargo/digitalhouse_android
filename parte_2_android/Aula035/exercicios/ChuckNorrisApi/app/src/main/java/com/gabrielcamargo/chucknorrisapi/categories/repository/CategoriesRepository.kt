package com.gabrielcamargo.chucknorrisapi.categories.repository

import android.content.Context

class CategoriesRepository(private val context: Context) {
    fun getCategories(callback: (categories: MutableList<String>) -> Unit) {
        callback.invoke(
            mutableListOf<String>(
                "categoria 1",
                "categoria 2",
                "categoria 3",
                "categoria 4"
            )
        )
    }
}
