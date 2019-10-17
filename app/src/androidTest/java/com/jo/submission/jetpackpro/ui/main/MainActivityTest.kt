package com.jo.submission.jetpackpro.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.utils.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun toDetailMovieTest() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_movie)).check(RecyclerViewItemCountAssertion(20))
        onView(withId(R.id.recycler_movie)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ViewActions.click()
            )
        )
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText("Joker")))
    }

    @Test
    fun toDetailTvShowTest() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tv_show)).perform(ViewActions.click())

        onView(withId(R.id.recycler_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_tv_show)).check(RecyclerViewItemCountAssertion(20))
        onView(withId(R.id.recycler_tv_show)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ViewActions.click()
            )
        )
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText("Fear the Walking Dead")))
    }
}