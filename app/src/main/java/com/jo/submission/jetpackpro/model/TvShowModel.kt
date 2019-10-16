package com.jo.submission.jetpackpro.model


import com.google.gson.annotations.SerializedName

data class TvShowModel(
    @SerializedName("results")
    val results: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int
)