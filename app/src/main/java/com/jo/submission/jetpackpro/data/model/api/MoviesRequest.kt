package com.jo.submission.jetpackpro.data.model.api

import com.google.gson.annotations.SerializedName

object MoviesRequest {
    class GetPopularMovies(
        @SerializedName("api_key")
        val apiKey: String,
        @SerializedName("language")
        val language: String?,
        @SerializedName("page")
        val page: String?,
        @SerializedName("region")
        val region: String?
    )
}