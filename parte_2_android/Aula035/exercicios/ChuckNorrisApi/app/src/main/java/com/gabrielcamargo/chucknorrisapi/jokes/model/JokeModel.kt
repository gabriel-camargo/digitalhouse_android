package com.gabrielcamargo.chucknorrisapi.jokes.model

import com.google.gson.annotations.SerializedName

data class JokeModel(
    @SerializedName("icon_url")
    val img: String,
    @SerializedName("value")
    val text: String
)