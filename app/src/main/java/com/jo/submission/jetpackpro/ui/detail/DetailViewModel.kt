package com.jo.submission.jetpackpro.ui.detail

import androidx.lifecycle.MutableLiveData
import com.jo.submission.jetpackpro.BuildConfig
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.model.TvShow
import com.jo.submission.jetpackpro.ui.base.BaseViewModel
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider

class DetailViewModel(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider
) :
    BaseViewModel<DetailNavigator>(dataManager, schedulerProvider) {

    var title: MutableLiveData<String> = MutableLiveData("")
    var date: MutableLiveData<String> = MutableLiveData("")
    var overview: MutableLiveData<String> = MutableLiveData("")

    var movie: Movie? = null
        set(value) {
            title.value = value?.title
            date.value = value?.releaseDate
            overview.value = value?.overview

            val urlPoster = BuildConfig.IMAGE_URL + value?.posterPath?.substring(1)
            val urlBackdrop = BuildConfig.IMAGE_URL + value?.backdropPath?.substring(1)
            getNavigator()?.showTitleAndImages("${title.value}", urlPoster, urlBackdrop)

            field = value
        }
    var tvShow: TvShow? = null
        set(value) {
            title.value = value?.name
            date.value = value?.firstAirDate
            overview.value = value?.overview

            val urlPoster = BuildConfig.IMAGE_URL + value?.posterPath?.substring(1)
            val urlBackdrop = BuildConfig.IMAGE_URL + value?.backdropPath?.substring(1)
            getNavigator()?.showTitleAndImages("${title.value}", urlPoster, urlBackdrop)

            field = value
        }
}