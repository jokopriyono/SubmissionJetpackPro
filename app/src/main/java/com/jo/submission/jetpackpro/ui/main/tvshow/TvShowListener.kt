package com.jo.submission.jetpackpro.ui.main.tvshow

import android.widget.ImageView
import com.jo.submission.jetpackpro.data.model.api.TvShow

interface TvShowListener {
    fun onTvShowClick(tvShow: TvShow)

    fun onLoadImage(target: ImageView, posterPath: String?)
}