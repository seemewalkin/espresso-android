package com.github.fgoncalves.qa.pageObject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.github.fgoncalves.qa.R

class WelcomePage : BasePage() {

    companion object {
        private val WELCOME_PAGE: WelcomePage by lazy {
            WelcomePage().also {
                onView(withId(R.id.clickMeBtn)).check(matches(isDisplayed()))
            }
        }
        fun onWelcomePage() = WELCOME_PAGE
    }


    fun isWelcomeTextDisplayed() = this.also {
        onView(withText("Welcome!"))
            .check(matches(isDisplayed()))
    }

    fun tapOnClickMeBtn() = this.also {
        onView(withId(R.id.clickMeBtn))
            .perform(click())
    }
}
