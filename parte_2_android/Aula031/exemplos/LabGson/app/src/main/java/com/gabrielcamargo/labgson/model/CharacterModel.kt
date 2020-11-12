package com.gabrielcamargo.labgson.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    val id: Int,
    @SerializedName("name")
    val nome: String,
    val status: String,
    @SerializedName("species")
    val especie: String,
    @SerializedName("type")
    val tipo: String,
    @SerializedName("gender")
    val genero: String,
    @SerializedName("origin")
    val origem: OriginModel,
    @SerializedName("location")
    val localizacao: LocationModel,
    @SerializedName("image")
    val imagem: String,
    @SerializedName("episode")
    val episodios: List<String>
)