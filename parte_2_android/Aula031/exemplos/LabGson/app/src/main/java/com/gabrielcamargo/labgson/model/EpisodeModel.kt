package com.gabrielcamargo.labgson.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("air_date")
    val data_estreia: String,
    @SerializedName("episode")
    val episodio: String,
    @SerializedName("characters")
    val personagens: List<String>
)