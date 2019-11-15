package com.jo.submission.jetpackpro.data.remote

import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {
    override fun getPopularMovies(request: MoviesRequest.GetPopularMovies): Single<MoviesResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_POPULAR_MOVIES)
            .addQueryParameter(request)
            .build()
            .getObjectSingle(MoviesResponse::class.java)

}