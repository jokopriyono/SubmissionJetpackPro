package com.jo.submission.jetpackpro.ui.main

import com.google.gson.Gson
import com.jo.submission.jetpackpro.model.MoviesModel
import com.jo.submission.jetpackpro.model.TvShowModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var dummyMoviesModel: MoviesModel
    private lateinit var dummyTvShowModel: TvShowModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
        val dummyMovieJsonString =
            "{ \"total_pages\": 500, \"results\": [ { \"popularity\": 588.352, \"vote_count\": 2891, \"video\": false, \"poster_path\": \"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg\", \"id\": 475557, \"adult\": false, \"backdrop_path\": \"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg\", \"original_language\": \"en\", \"original_title\": \"Joker\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"Joker\", \"vote_average\": 8.6, \"overview\": \"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.\", \"release_date\": \"2019-10-04\" }, { \"popularity\": 295.457, \"vote_count\": 2930, \"video\": false, \"poster_path\": \"/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg\", \"id\": 420818, \"adult\": false, \"backdrop_path\": \"/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg\", \"original_language\": \"en\", \"original_title\": \"The Lion King\", \"genre_ids\": [ 12, 16, 18, 10751 ], \"title\": \"The Lion King\", \"vote_average\": 7.1, \"overview\": \"Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.\", \"release_date\": \"2019-07-19\" }, { \"popularity\": 244.292, \"vote_count\": 754, \"video\": false, \"poster_path\": \"/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg\", \"id\": 559969, \"adult\": false, \"backdrop_path\": \"/uLXK1LQM28XovWHPao3ViTeggXA.jpg\", \"original_language\": \"en\", \"original_title\": \"El Camino: A Breaking Bad Movie\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"El Camino: A Breaking Bad Movie\", \"vote_average\": 7.3, \"overview\": \"In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.\", \"release_date\": \"2019-10-11\" } ]}"
        val dummyTvShowJsonString =
            "{ \"total_pages\": 500, \"results\": [ { \"original_name\": \"Fear the Walking Dead\", \"genre_ids\": [ 18, 27 ], \"name\": \"Fear the Walking Dead\", \"popularity\": 452.849, \"origin_country\": [ \"US\" ], \"vote_count\": 1060, \"first_air_date\": \"2015-08-23\", \"backdrop_path\": \"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\", \"original_language\": \"en\", \"id\": 62286, \"vote_average\": 6.3, \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\", \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\" }, { \"original_name\": \"Batwoman\", \"genre_ids\": [ 10759, 10765 ], \"name\": \"Batwoman\", \"popularity\": 298.277, \"origin_country\": [ \"US\" ], \"vote_count\": 61, \"first_air_date\": \"2019-10-06\", \"backdrop_path\": \"/spc5mNkW2daK1ob7Z7jqNkSlKS2.jpg\", \"original_language\": \"en\", \"id\": 89247, \"vote_average\": 6.9, \"overview\": \"Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.\", \"poster_path\": \"/jnaimWkIVSD9IInmZPyLYarSvvc.jpg\" }, { \"original_name\": \"Arrow\", \"genre_ids\": [ 80, 18, 9648, 10759 ], \"name\": \"Arrow\", \"popularity\": 332.397, \"origin_country\": [ \"US\" ], \"vote_count\": 2694, \"first_air_date\": \"2012-10-10\", \"backdrop_path\": \"/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg\", \"original_language\": \"en\", \"id\": 1412, \"vote_average\": 5.8, \"overview\": \"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\", \"poster_path\": \"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg\" } ]}"
        dummyMoviesModel = Gson().fromJson(dummyMovieJsonString, MoviesModel::class.java)
        dummyTvShowModel = Gson().fromJson(dummyTvShowJsonString, TvShowModel::class.java)

        mainViewModel.movies = dummyMoviesModel
        mainViewModel.tvShow = dummyTvShowModel
    }

    @Test
    fun loadMoviesTest() {
        assertNotNull(mainViewModel.movies)
        assertEquals(3, mainViewModel.movies.results.size)
        assertEquals(dummyMoviesModel.results[0], mainViewModel.movies.results[0])
        assertEquals(dummyMoviesModel.results[1], mainViewModel.movies.results[1])
        assertEquals(dummyMoviesModel.results[2], mainViewModel.movies.results[2])

        assertEquals(dummyMoviesModel.results[0].id, mainViewModel.movies.results[0].id)
        assertEquals(
            dummyMoviesModel.results[0].releaseDate,
            mainViewModel.movies.results[0].releaseDate
        )
        assertEquals(dummyMoviesModel.results[0].overview, mainViewModel.movies.results[0].overview)
        assertEquals(dummyMoviesModel.results[0].title, mainViewModel.movies.results[0].title)
        assertEquals(
            dummyMoviesModel.results[0].originalTitle,
            mainViewModel.movies.results[0].originalTitle
        )
        assertEquals(
            dummyMoviesModel.results[0].posterPath,
            mainViewModel.movies.results[0].posterPath
        )
        assertEquals(
            dummyMoviesModel.results[0].backdropPath,
            mainViewModel.movies.results[0].backdropPath
        )
        assertEquals(dummyMoviesModel.results[0].adult, mainViewModel.movies.results[0].adult)
        assertEquals(dummyMoviesModel.results[0].genreIds, mainViewModel.movies.results[0].genreIds)
        assertEquals(
            dummyMoviesModel.results[0].originalLanguage,
            mainViewModel.movies.results[0].originalLanguage
        )
        assertEquals(
            dummyMoviesModel.results[0].popularity,
            mainViewModel.movies.results[0].popularity,
            0.0001
        )
        assertEquals(dummyMoviesModel.results[0].video, mainViewModel.movies.results[0].video)
        assertEquals(
            dummyMoviesModel.results[0].voteAverage,
            mainViewModel.movies.results[0].voteAverage,
            0.0001
        )
        assertEquals(
            dummyMoviesModel.results[0].voteCount,
            mainViewModel.movies.results[0].voteCount
        )
    }

    @Test
    fun loadTvShowTest() {
        assertNotNull(mainViewModel.tvShow)
        assertEquals(3, mainViewModel.tvShow.results.size)
        assertEquals(dummyTvShowModel.results[0], mainViewModel.tvShow.results[0])
        assertEquals(dummyTvShowModel.results[1], mainViewModel.tvShow.results[1])
        assertEquals(dummyTvShowModel.results[2], mainViewModel.tvShow.results[2])

        assertEquals(dummyTvShowModel.results[0].id, mainViewModel.tvShow.results[0].id)
        assertEquals(
            dummyTvShowModel.results[0].firstAirDate,
            mainViewModel.tvShow.results[0].firstAirDate
        )
        assertEquals(dummyTvShowModel.results[0].overview, mainViewModel.tvShow.results[0].overview)
        assertEquals(
            dummyTvShowModel.results[0].originalName,
            mainViewModel.tvShow.results[0].originalName
        )
        assertEquals(dummyTvShowModel.results[0].name, mainViewModel.tvShow.results[0].name)
        assertEquals(
            dummyTvShowModel.results[0].posterPath,
            mainViewModel.tvShow.results[0].posterPath
        )
        assertEquals(
            dummyTvShowModel.results[0].backdropPath,
            mainViewModel.tvShow.results[0].backdropPath
        )
        assertEquals(
            dummyTvShowModel.results[0].originCountry,
            mainViewModel.tvShow.results[0].originCountry
        )
        assertEquals(dummyTvShowModel.results[0].genreIds, mainViewModel.tvShow.results[0].genreIds)
        assertEquals(
            dummyTvShowModel.results[0].originalLanguage,
            mainViewModel.tvShow.results[0].originalLanguage
        )
        assertEquals(
            dummyTvShowModel.results[0].popularity,
            mainViewModel.tvShow.results[0].popularity,
            0.0001
        )
        assertEquals(
            dummyTvShowModel.results[0].voteAverage,
            mainViewModel.tvShow.results[0].voteAverage,
            0.0001
        )
        assertEquals(
            dummyTvShowModel.results[0].voteCount,
            mainViewModel.tvShow.results[0].voteCount
        )
    }
}