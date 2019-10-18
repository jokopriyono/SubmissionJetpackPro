package com.jo.submission.jetpackpro.ui.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.google.gson.Gson
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.Movie
import org.junit.Rule
import org.junit.Test

class DetailActivityTest {

    private val movieString =
        "{ \"popularity\": 588.352, \"vote_count\": 2891, \"video\": false, \"poster_path\": \"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg\", \"id\": 475557, \"adult\": false, \"backdrop_path\": \"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg\", \"original_language\": \"en\", \"original_title\": \"Joker\", \"genre_ids\": [ 80, 18, 53 ], \"title\": \"Joker\", \"vote_average\": 8.6, \"overview\": \"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.\", \"release_date\": \"2019-10-04\" }"
    private lateinit var dummyMovie: Movie

//    private val tvShowString =
//        "{ \"original_name\": \"Fear the Walking Dead\", \"genre_ids\": [ 18, 27 ], \"name\": \"Fear the Walking Dead\", \"popularity\": 452.849, \"origin_country\": [ \"US\" ], \"vote_count\": 1060, \"first_air_date\": \"2015-08-23\", \"backdrop_path\": \"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\", \"original_language\": \"en\", \"id\": 62286, \"vote_average\": 6.3, \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\", \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\" }"
//    private lateinit var dummyTvShow: TvShow

    @get:Rule
    val activityRule = object : ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext, DetailActivity::class.java)

            dummyMovie = Gson().fromJson(movieString, Movie::class.java)
            result.putExtra(DetailActivity.INTENT_DATA, dummyMovie)
//            dummyTvShow = Gson().fromJson(tvShowString, TvShow::class.java)
//            result.putExtra(DetailActivity.INTENT_DATA_2, dummyTvShow)
            return result
        }
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyMovie.title)))
        onView(withId(R.id.txt_date)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date)).check(matches(withText(dummyMovie.releaseDate)))
    }
}