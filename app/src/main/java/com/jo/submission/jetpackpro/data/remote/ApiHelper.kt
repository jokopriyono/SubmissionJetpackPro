package com.jo.submission.jetpackpro.data.remote

import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import io.reactivex.Single

interface ApiHelper {

    fun getPopularMovies(request: MoviesRequest.GetPopularMovies): Single<MoviesResponse>

}