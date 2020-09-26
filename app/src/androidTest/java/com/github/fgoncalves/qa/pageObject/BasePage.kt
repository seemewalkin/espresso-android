package com.github.fgoncalves.qa.pageObject

import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.RootMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.Espresso.onView


abstract class BasePage {

    fun verifyTextIsVisible(text: String, activityTestRule: ActivityTestRule<*>) {
         onView(withText(text))
             .inRoot(withDecorView(not(activityTestRule.activity.window.decorView)))
             .check(matches(isDisplayed()))
    }
}