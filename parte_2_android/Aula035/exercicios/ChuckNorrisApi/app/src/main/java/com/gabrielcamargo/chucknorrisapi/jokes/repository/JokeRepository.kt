package com.gabrielcamargo.chucknorrisapi.jokes.repository

class JokeRepository() {
    private val client = JokeEndpoint.endpoint

    suspend fun getJoke(category: String) = client.get(category)
}
