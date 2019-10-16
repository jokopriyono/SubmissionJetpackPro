package com.jo.submission.jetpackpro.model


import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int
)