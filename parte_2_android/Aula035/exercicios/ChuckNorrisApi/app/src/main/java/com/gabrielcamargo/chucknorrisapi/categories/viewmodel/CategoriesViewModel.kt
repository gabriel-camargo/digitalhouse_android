package com.gabrielcamargo.chucknorrisapi.categories.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.chucknorrisapi.categories.repository.CategoriesRepository

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : ViewModel() {
    val categories = MutableLiveData<MutableList<String>>()

    fun getCategories() {
        repository.getCategories {
            categories.value = it
        }
    }

    @Suppress("UNCHECKED_CAST")
    class CategoriesViewModelFactory(
        private val repository: CategoriesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriesViewModel(repository) as T
        }

    }
}