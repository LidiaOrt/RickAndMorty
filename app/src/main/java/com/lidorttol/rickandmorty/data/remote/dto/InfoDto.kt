package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

class InfoDto (
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("prev")
    val prev: String? = null,
)