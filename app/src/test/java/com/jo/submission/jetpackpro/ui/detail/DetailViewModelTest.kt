package com.jo.submission.jetpackpro.ui.detail

import com.google.gson.Gson
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.model.TvShow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var dummyMovie: Movie
    private lateinit var dummyTvShow: TvShow

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        val movieString =
            "{ \"popularity\": 588.352, \"vote_count\": 2891, \"video\": false, \"poster_path\": \"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg\", \"id\": 475557, \"adult\": false, \"backdrop_path\": \"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg\", \"original_language\": \"en\", \"original_title\": \"Joker\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"Joker\", \"vote_average\": 8.6, \"overview\": \"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.\", \"release_date\": \"2019-10-04\" }"
        val tvShowString =
            "{ \"original_name\": \"Fear the Walking Dead\", \"genre_ids\": [ 18, 27 ], \"name\": \"Fear the Walking Dead\", \"popularity\": 452.849, \"origin_country\": [ \"US\" ], \"vote_count\": 1060, \"first_air_date\": \"2015-08-23\", \"backdrop_path\": \"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\", \"original_language\": \"en\", \"id\": 62286, \"vote_average\": 6.3, \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\", \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\" }"
        dummyMovie = Gson().fromJson(movieString, Movie::class.java)
        dummyTvShow = Gson().fromJson(tvShowString, TvShow::class.java)

        detailViewModel.movie = dummyMovie
        detailViewModel.tvShow = dummyTvShow
    }

    @Test
    fun getMovie() {
        assertNotNull(dummyMovie)
        assertEquals(dummyMovie.id, detailViewModel.movie.id)
        assertEquals(dummyMovie.backdropPath, detailViewModel.movie.backdropPath)
        assertEquals(dummyMovie.posterPath, detailViewModel.movie.posterPath)
        assertEquals(dummyMovie.originalTitle, detailViewModel.movie.originalTitle)
        assertEquals(dummyMovie.title, detailViewModel.movie.title)
        assertEquals(dummyMovie.releaseDate, detailViewModel.movie.releaseDate)
        assertEquals(dummyMovie.overview, detailViewModel.movie.overview)
    }

    @Test
    fun getTvShow() {
        assertNotNull(dummyTvShow)
        assertEquals(dummyTvShow.id, detailViewModel.tvShow.id)
        assertEquals(dummyTvShow.backdropPath, detailViewModel.tvShow.backdropPath)
        assertEquals(dummyTvShow.posterPath, detailViewModel.tvShow.posterPath)
        assertEquals(dummyTvShow.name, detailViewModel.tvShow.name)
        assertEquals(dummyTvShow.originalName, detailViewModel.tvShow.originalName)
        assertEquals(dummyTvShow.firstAirDate, detailViewModel.tvShow.firstAirDate)
        assertEquals(dummyTvShow.overview, detailViewModel.tvShow.overview)
    }
}