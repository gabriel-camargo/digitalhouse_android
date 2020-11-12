package com.gabrielcamargo.labgson.model

import com.google.gson.annotations.SerializedName

class PageInfoModel (
    @SerializedName("count")
    val total:Int,
    @SerializedName("pages")
    val paginas: Int,
    @SerializedName("next")
    val proximo: String?,
    @SerializedName("prev")
    val anterior: String?
)