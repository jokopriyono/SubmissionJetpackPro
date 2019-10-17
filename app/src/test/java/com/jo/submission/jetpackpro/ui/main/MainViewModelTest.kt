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
    private val dummyMovieJsonString =
        "{ \"total_pages\": 500, \"results\": [ { \"popularity\": 588.352, \"vote_count\": 2891, \"video\": false, \"poster_path\": \"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg\", \"id\": 475557, \"adult\": false, \"backdrop_path\": \"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg\", \"original_language\": \"en\", \"original_title\": \"Joker\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"Joker\", \"vote_average\": 8.6, \"overview\": \"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.\", \"release_date\": \"2019-10-04\" }, { \"popularity\": 295.457, \"vote_count\": 2930, \"video\": false, \"poster_path\": \"/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg\", \"id\": 420818, \"adult\": false, \"backdrop_path\": \"/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg\", \"original_language\": \"en\", \"original_title\": \"The Lion King\", \"genre_ids\": [ 12, 16, 18, 10751 ], \"title\": \"The Lion King\", \"vote_average\": 7.1, \"overview\": \"Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.\", \"release_date\": \"2019-07-19\" }, { \"popularity\": 244.292, \"vote_count\": 754, \"video\": false, \"poster_path\": \"/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg\", \"id\": 559969, \"adult\": false, \"backdrop_path\": \"/uLXK1LQM28XovWHPao3ViTeggXA.jpg\", \"original_language\": \"en\", \"original_title\": \"El Camino: A Breaking Bad Movie\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"El Camino: A Breaking Bad Movie\", \"vote_average\": 7.3, \"overview\": \"In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.\", \"release_date\": \"2019-10-11\" } ]}"
    private val dummyTvShowJsonString =
        "{ \"total_pages\": 500, \"results\": [ { \"original_name\": \"Fear the Walking Dead\", \"genre_ids\": [ 18, 27 ], \"name\": \"Fear the Walking Dead\", \"popularity\": 452.849, \"origin_country\": [ \"US\" ], \"vote_count\": 1060, \"first_air_date\": \"2015-08-23\", \"backdrop_path\": \"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\", \"original_language\": \"en\", \"id\": 62286, \"vote_average\": 6.3, \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\", \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\" }, { \"original_name\": \"Batwoman\", \"genre_ids\": [ 10759, 10765 ], \"name\": \"Batwoman\", \"popularity\": 298.277, \"origin_country\": [ \"US\" ], \"vote_count\": 61, \"first_air_date\": \"2019-10-06\", \"backdrop_path\": \"/spc5mNkW2daK1ob7Z7jqNkSlKS2.jpg\", \"original_language\": \"en\", \"id\": 89247, \"vote_average\": 6.9, \"overview\": \"Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.\", \"poster_path\": \"/jnaimWkIVSD9IInmZPyLYarSvvc.jpg\" }, { \"original_name\": \"Arrow\", \"genre_ids\": [ 80, 18, 9648, 10759 ], \"name\": \"Arrow\", \"popularity\": 332.397, \"origin_country\": [ \"US\" ], \"vote_count\": 2694, \"first_air_date\": \"2012-10-10\", \"backdrop_path\": \"/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg\", \"original_language\": \"en\", \"id\": 1412, \"vote_average\": 5.8, \"overview\": \"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\", \"poster_path\": \"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg\" } ]}"

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun loadMoviesTest() {
        val movies = Gson().fromJson(dummyMovieJsonString, MoviesModel::class.java)
        assertNotNull(movies)
        assertEquals(3, movies.results.size)
    }

    @Test
    fun loadTvShowTest() {
        val tvShows = Gson().fromJson(dummyTvShowJsonString, TvShowModel::class.java)
        assertNotNull(tvShows)
        assertEquals(3, tvShows.results.size)
    }
}