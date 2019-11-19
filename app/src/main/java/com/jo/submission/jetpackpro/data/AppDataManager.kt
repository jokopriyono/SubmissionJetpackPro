package com.jo.submission.jetpackpro.data

import android.content.Context
import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.jo.submission.jetpackpro.data.model.api.TvShowRequest
import com.jo.submission.jetpackpro.data.model.api.TvShowResponse
import com.jo.submission.jetpackpro.data.remote.ApiHelper
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val context: Context,
    private val apiHelper: ApiHelper
) :
    DataManager {
    override fun getPopularMovies(request: MoviesRequest.GetPopularMovies): Single<MoviesResponse> =
        apiHelper.getPopularMovies(request)

    override fun getPopularTvShow(request: TvShowRequest.GetPopularTvShow): Single<TvShowResponse> =
        apiHelper.getPopularTvShow(request)

}