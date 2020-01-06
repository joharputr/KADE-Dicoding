package com.example.ankolayout

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.ankolayout.Home.Activity.Home
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TestingUI {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(Home::class.java)

    @Test
    fun testingSearch() {
        Thread.sleep(3000)
        onView(withId(R.id.recyclerviewHome)).check(matches(isDisplayed()))
        Thread.sleep(4000)

        onView(withId(R.id.recyclerviewHome)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerviewHome)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10)
        )
        onView(withId(R.id.recyclerviewHome)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
        )
        Thread.sleep(4000)
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.descDetail)).check(matches(isDisplayed()))
        Thread.sleep(4000)
        onView(withId(R.id.searchViewNext)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.searchViewNext)).perform(typeText("nice"), pressKey(KeyEvent.KEYCODE_ENTER));
        Thread.sleep(4000)
        onView(withId(R.id.RecyclerDetailSearch)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
        )
        Thread.sleep(4000)
    }


}