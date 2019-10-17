package com.jo.submission.jetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.model.TvShow

class DetailViewModel : ViewModel() {
    lateinit var movie: Movie
    lateinit var tvShow: TvShow
}