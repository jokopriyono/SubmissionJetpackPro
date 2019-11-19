package com.jo.submission.jetpackpro.ui.main

import androidx.lifecycle.MutableLiveData
import com.jo.submission.jetpackpro.BuildConfig
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.jo.submission.jetpackpro.data.model.api.TvShowRequest
import com.jo.submission.jetpackpro.data.model.api.TvShowResponse
import com.jo.submission.jetpackpro.ui.base.BaseViewModel
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider

class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<MainNavigator>(dataManager, schedulerProvider) {

    init {
        fetchMoviesFromRemote()
        fetchTvShowsFromRemote()
    }

    var movies: MutableLiveData<MoviesResponse?> = MutableLiveData()
    var tvShows: MutableLiveData<TvShowResponse?> = MutableLiveData()

    fun fetchMoviesFromRemote() {
        val request = MoviesRequest.GetPopularMovies(apiKey = BuildConfig.API_KEY)
        val dispose = dataManager.getPopularMovies(request)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSuccess {
                movies.postValue(it)
            }
            .doOnError {
                getNavigator()?.handleError(it)
            }
            .subscribe()

        compositeDisposable.add(dispose)

    }

    fun fetchTvShowsFromRemote() {
        val request = TvShowRequest.GetPopularTvShow(apiKey = BuildConfig.API_KEY)
        val dispose = dataManager.getPopularTvShow(request)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe { tvShowResponse: TvShowResponse?, throwable: Throwable? ->
                tvShows.postValue(tvShowResponse)
                getNavigator()?.handleError(throwable)
            }

        compositeDisposable.add(dispose)
    }
}