package com.jo.submission.jetpackpro.ui.main

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.MoviesModel
import com.jo.submission.jetpackpro.model.TvShowModel
import java.nio.charset.Charset


class MainViewModel : ViewModel() {

    lateinit var movies: MoviesModel
    lateinit var tvShow: TvShowModel

    fun setupResources(resources: Resources) {
        this.movies = loadMovies(resources)
        this.tvShow = loadTvShow(resources)
    }

    private fun loadMovies(resources: Resources): MoviesModel {
        val resRaw = resources.openRawResource(R.raw.movies)
        val size = resRaw.available()
        val buffer = ByteArray(size)
        resRaw.read(buffer)
        resRaw.close()

        val json = String(buffer, Charset.defaultCharset())
        return Gson().fromJson(json, MoviesModel::class.java)
    }

    private fun loadTvShow(resources: Resources): TvShowModel {
        val resRaw = resources.openRawResource(R.raw.tvshow)
        val size = resRaw.available()
        val buffer = ByteArray(size)
        resRaw.read(buffer)
        resRaw.close()

        val json = String(buffer, Charset.defaultCharset())
        return Gson().fromJson(json, TvShowModel::class.java)
    }

}