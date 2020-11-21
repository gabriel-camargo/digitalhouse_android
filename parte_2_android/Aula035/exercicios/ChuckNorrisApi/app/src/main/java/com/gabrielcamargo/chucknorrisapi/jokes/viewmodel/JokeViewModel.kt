package com.gabrielcamargo.chucknorrisapi.jokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielcamargo.chucknorrisapi.jokes.model.JokeModel
import com.gabrielcamargo.chucknorrisapi.jokes.repository.JokeRepository
import kotlinx.coroutines.Dispatchers

class JokeViewModel(
    private val repository: JokeRepository
) : ViewModel() {
    var joke: JokeModel? = null

    fun getJoke(category: String) = liveData(Dispatchers.IO) {
        val response = repository.getJoke(category)
        joke = response
        emit(response)
    }

    class JokeViewModelFactory(
        private val repository: JokeRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return JokeViewModel(repository) as T
        }

    }
}