package com.jo.submission.jetpackpro.ui.main

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.jo.submission.jetpackpro.BuildConfig
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.jo.submission.jetpackpro.model.MoviesModel
import com.jo.submission.jetpackpro.model.TvShowModel
import com.jo.submission.jetpackpro.ui.base.BaseViewModel
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import java.nio.charset.Charset


class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<MainNavigator>(dataManager, schedulerProvider) {

    init {
        fetchMoviesFromRemote()
    }

    var moviess = MutableLiveData<MoviesResponse?>(null)

    lateinit var movies: MoviesModel

    lateinit var tvShow: TvShowModel
    fun setupResources(resources: Resources) {
        this.movies = loadMovies(resources)
        this.tvShow = loadTvShow(resources)
    }

    private fun fetchMoviesFromRemote() {
        val request = MoviesRequest.GetPopularMovies(apiKey = BuildConfig.API_KEY)

        compositeDisposable.add(
            dataManager.getPopularMovies(request)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe { moviesResponse: MoviesResponse?, throwable: Throwable? ->
                    moviess.value = moviesResponse
                    getNavigator()?.handleError(throwable)
                }
        )
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