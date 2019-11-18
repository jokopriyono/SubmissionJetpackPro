package com.jo.submission.jetpackpro.ui.main.movies

import android.widget.ImageView
import com.jo.submission.jetpackpro.data.model.api.Movie

interface MovieListener {
    fun onMovieClick(movie: Movie)

    fun onLoadImage(target: ImageView, posterPath: String)
}