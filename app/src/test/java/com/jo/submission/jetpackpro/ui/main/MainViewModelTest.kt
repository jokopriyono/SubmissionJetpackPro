package com.jo.submission.jetpackpro.ui.main

import androidx.lifecycle.Observer
import com.jo.submission.jetpackpro.BuildConfig
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.data.model.api.Movie
import com.jo.submission.jetpackpro.data.model.api.MoviesRequest
import com.jo.submission.jetpackpro.data.model.api.MoviesResponse
import com.jo.submission.jetpackpro.ui.utils.mock
import com.jo.submission.jetpackpro.ui.utils.rx.TestSchedulerProvider
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()

    companion object {
        @BeforeClass
        @Throws(Exception::class)
        fun onlyOnce() {
        }
    }

    @Mock
    lateinit var mockMainNavigator: MainNavigator
    @Mock
    lateinit var mockDataManager: DataManager
    private lateinit var mainViewModel: MainViewModel
    private lateinit var testScheduler: TestScheduler

    @Before
    fun setUp() {
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
//        val testScheduler = AppSchedulerProvider(testScheduler)
        mainViewModel = MainViewModel(mockDataManager, testSchedulerProvider)
        mainViewModel.setNavigator(mockMainNavigator)
    }

    @Test
    fun testFetchMoviesFromRemote() {
        val dummyMovie =
            Movie(
                false,
                "backdrop",
                emptyList(),
                10,
                "ID",
                "Dicoding",
                "Dicoding Indonesia",
                70.0,
                "poster",
                "12-12-1212",
                "Dicoding",
                false,
                99.0,
                100
            )
        val dummyResponse = MoviesResponse(1, listOf(dummyMovie), 1, 1)

//        doReturn(Single.just(dummyResponse))
//            .`when`(mockDataManager)
//            .getPopularMovies(MoviesRequest.GetPopularMovies(apiKey = BuildConfig.API_KEY))

        `when`(mockDataManager.getPopularMovies(MoviesRequest.GetPopularMovies(apiKey = BuildConfig.API_KEY)))
            .thenReturn(Single.just(dummyResponse))

        mainViewModel.fetchMoviesFromRemote()
        testScheduler.triggerActions()
//
        val movies = mainViewModel.movies
        val observer: Observer<MoviesResponse?> = mock()
        movies.observeForever(observer)
        verify(observer).onChanged(dummyResponse)
    }
}