package com.jo.submission.jetpackpro.data.remote

import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.jo.submission.jetpackpro.data.model.api.TvShowRequest
import com.jo.submission.jetpackpro.data.model.api.TvShowResponse
import io.reactivex.Single

interface ApiHelper {

    fun getPopularMovies(request: MoviesRequest.GetPopularMovies): Single<MoviesResponse>

    fun getPopularTvShow(request: TvShowRequest.GetPopularTvShow): Single<TvShowResponse>

}