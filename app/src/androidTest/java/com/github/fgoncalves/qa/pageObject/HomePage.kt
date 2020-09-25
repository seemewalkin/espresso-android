package com.github.fgoncalves.qa.pageObject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.github.fgoncalves.qa.R

class HomePage : BasePage() {

    companion object {
        private val HOME_PAGE: HomePage by lazy {
            HomePage().also {
                onView(withId(R.id.imageOfTheHouse)).check(matches(isDisplayed()))
            }
        }

        fun onHomePage() = HOME_PAGE
    }



    fun tapClickMeButton() = this.also {
        onView(withId(R.id.OutOfHomeBtn))
            .perform(click())
    }

    fun isHomeImageVisible() = this.also {
        onView(withId(R.id.imageOfTheHouse))
            .check(matches(isDisplayed()))
    }
}
