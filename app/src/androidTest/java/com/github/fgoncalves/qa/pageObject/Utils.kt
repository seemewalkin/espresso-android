package com.github.fgoncalves.qa.pageObject

import android.view.View
import androidx.test.espresso.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.hamcrest.Matcher

object EspressoExtensions {

    fun waitForView(
        viewMatcher: Matcher<View>,
        waitMillis: Int = 5000,
        waitMillisPerTry: Long = 100
    ): ViewInteraction {

        val maxTries = waitMillis / waitMillisPerTry.toInt()

        var tries = 0

        for (i in 0..maxTries) {
            try {
                tries++
                Espresso.onView(viewMatcher).check(matches(isDisplayed()))
                return Espresso.onView(viewMatcher)

            } catch (e: Exception) {

                if (tries == maxTries) {
                    break
                }
                Thread.sleep(waitMillisPerTry)
            }
        }
        throw Exception("Error finding a view matching $viewMatcher")
    }

    fun doOnView(matcher: Matcher<View>, vararg actions: ViewAction) {
        actions.forEach {
            waitForView(matcher).perform(it)
        }
    }

    fun assertOnView(matcher: Matcher<View>, vararg assertions: ViewAssertion) {
        assertions.forEach {
            waitForView(matcher).check(it)
        }
    }
}