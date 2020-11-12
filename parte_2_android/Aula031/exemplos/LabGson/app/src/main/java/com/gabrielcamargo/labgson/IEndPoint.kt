package com.gabrielcamargo.labgson

import com.gabrielcamargo.labgson.model.ApiResponseModel
import com.gabrielcamargo.labgson.model.CharacterModel
import com.gabrielcamargo.labgson.model.EpisodeModel
import com.gabrielcamargo.labgson.model.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface IEndPoint {

    @GET("character")
    fun obterPersonagens(): Call<ApiResponseModel<CharacterModel>>

    @GET("location")
    fun obterLocalizacao(): Call<ApiResponseModel<LocationModel>>

    @GET("episode")
    fun obterEpisodios(): Call<ApiResponseModel<EpisodeModel>>
}