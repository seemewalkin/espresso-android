package com.github.fgoncalves.qa.pageObject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.github.fgoncalves.qa.R
import com.github.fgoncalves.qa.pageObject.EspressoExtensions.waitForView
import com.github.fgoncalves.qa.pageObject.EspressoExtensions.assertOnView



class HomePage : BasePage() {

    companion object {
        private val HOME_PAGE: HomePage by lazy {
            HomePage().also {
                onView(withId(R.id.login_progress)).check(matches(isDisplayed()))
            }
        }

        fun onHomePage() = HOME_PAGE
    }

    fun waitForClickMeBtn() = this.also {
        (waitForView(withId(R.id.OutOfHomeBtn), 10000, 10000))
    }

    fun tapClickMeButton() = this.also {
        onView(withId(R.id.OutOfHomeBtn))
            .perform(click())
    }

    fun isSpinnerVisible() = this.also {
        onView(withId(R.id.login_progress))
            .check(matches(isDisplayed()))
    }

    fun waitForImageToBeDisplayed() = this.also {
        assertOnView(withId(R.id.imageOfTheHouse), matches(isDisplayed()))
    }
}
