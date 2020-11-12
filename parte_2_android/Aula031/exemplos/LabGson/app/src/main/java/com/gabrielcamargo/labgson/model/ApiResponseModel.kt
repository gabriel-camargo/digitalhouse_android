package com.gabrielcamargo.labgson.model

data class ApiResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)